package Gui.Controller;

import java.io.IOException;

import GameObjects.Ball;
import GameObjects.CircleObstacle;
import GameObjects.Cross;
import GameObjects.Dash;
import GameObjects.Obstacle;
import GameObjects.Star;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Classic{
	private Controller controller = Controller.getInstance();
    @FXML private Text StarText;
    @FXML private Text ScoreText;
    @FXML private AnchorPane pane;
    private Obstacle o1;
	private Obstacle o2;
	private Obstacle o3;
	private Star s;
	private Ball ball;
	private int H = 720;
	private int W = 1280;
	double velocityY = 0;
	TranslateTransition t1 = new TranslateTransition();
	TranslateTransition t2= new TranslateTransition();
	TranslateTransition t3 = new TranslateTransition();
	TranslateTransition ts = new TranslateTransition();
	@FXML private ImageView pause;
	
	@FXML
	private void PauseButton(Event event) {
		try {
			controller.sceneChanger.getPauseMenu(event);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
     
    @FXML
    public void initialize() {
    	StarText.setVisible(true);
//    	pause.setVisible(true);
    	o1 = new CircleObstacle(pane, controller.currY);
		o2 = new Cross(pane, controller.currY);
		o3 = new Dash(pane, controller.currY);
		s = new Star(pane, controller.currStarY);
		controller.objects.add(o1);
		controller.objects.add(o2);
		controller.objects.add(o3);
		controller.objects.add(s);
		ball = new Ball(W/2, W/2, 8);
		pane.getChildren().add(ball.getNode());		
		createInitialBlocks();
		
		pane.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//				if(event.getCode()==KeyCode.UP) {
					controller.hitSpace=true;
//				}
			}
		});
		new java.util.Timer().schedule(
              new java.util.TimerTask() {
                  @Override
                  public void run() {
                	  controller.removeUnwantedObject();
                  }
              },1, 1);
		
		Timeline timeline = new Timeline(new KeyFrame(new Duration(1000), actionEvent->{
			if(ball.getCenterY()<360) {
				updateObjects();
			}
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
        
        
		
        AnimationTimer timer1 = new AnimationTimer() {
			double myTime = 0.0;
			double gravity = 15;
			@Override
			public void handle(long arg0) {
				StarText.setText("" + controller.stars);
				double currY = ball.getCenterY();
				velocityY += gravity*0.5*Math.pow(myTime, 2);
				double deltaY = velocityY;
				double newY = currY + deltaY;
				
				if(controller.hitSpace) {
					velocityY =- 4;
					myTime = .13;
					/*if(ball.getCenterY()<420) {
						updateObjects();
					}*/
					if(ball.getCenterY()<s.getLocationY()) {
						controller.updateScore();
						s.setMovedOffScreen(true);
					}
					controller.hitSpace = false;
				}
				ball.setCenterY(newY);
				if(checkGameOver(ball)) {
					this.stop();
//					timeline.stop();
					gameOver();
				}
				myTime += .001;
			}
		};
		timer1.start();
    }
    
    private void createInitialBlocks() {
		o1.relocate(W/2-75, controller.currY);
		controller.currY= controller.currY-300;
		o2.relocate(W/2-40, controller.currY);
		controller.currY= controller.currY-300;
		o3.relocate(W/2, controller.currY);
		controller.currY= controller.currY-300;
		s.relocate(W/2-20, controller.currY);
		controller.currY= controller.currY-300;

	}
	
	private boolean checkGameOver(Ball ball) {
		if(o1.checkIntersect((Circle)ball.getNode(), ball.getBoundsInParent())) return true;
		if(o2.checkIntersect((Circle)ball.getNode(), ball.getBoundsInParent())) return true;
		if(o3.checkIntersect((Circle)ball.getNode(), ball.getBoundsInParent())) return true;
		return false;
	}
	
	private void gameOver() {
		Text gameOver = new Text(W/2-50, H/2, "Game Over!");
		gameOver.setFill(Color.RED);
		gameOver.setFont(Font.font("Verdana", 20));
		pane.getChildren().add(gameOver);
	}

	private void updateObjects() {
		
		translate((Node)o1.getNode(), 0, 50, 1, 800, false);
		translate((Node)o2.getNode(), 0, 50, 1, 800, false);
		translate((Node)o3.getNode(), 0, 50, 1, 800, false);
		translate((Node)s.getNode(), 0, 50, 1, 800, false);
		
	}

	void translate(Node node,int x,int y,int cyclecount,int timeMilli,boolean reverse){
        TranslateTransition translate = new TranslateTransition();
        {
            translate.setDuration(Duration.millis(timeMilli));
            translate.setCycleCount(cyclecount);
            translate.setAutoReverse(reverse);
            translate.setNode(node);
        }
        translate.setByX(x);
        translate.setByY(y);
        translate.play();

    }
}

