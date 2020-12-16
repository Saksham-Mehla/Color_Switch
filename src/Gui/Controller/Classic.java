package Gui.Controller;

import java.io.IOException;
import java.util.ArrayList;
import GameObjects.Ball;
import GameObjects.CircleObstacle;
import GameObjects.Cross;
import GameObjects.Dash;
import GameObjects.Obstacle;
import GameObjects.Star;
import GameObjects.State;
import Interfaces.GameObject;
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

public class Classic {
	private Controller controller = Controller.getInstance();
//	public static State currState = null;
    @FXML private Text StarText;
    @FXML private Text ScoreText;
    @FXML private AnchorPane pane;
    public ArrayList<GameObject> objects = new ArrayList<>();
    public int currY = 300;
    public int currStarY = 250;

    private Obstacle o1;
	private Obstacle o2;
	private Obstacle o3;
	private Star s;
	private Ball ball;
	private int H = 720;
	private int W = 1280;
	double velocityY = 0;
	int stars;
	TranslateTransition t1 = new TranslateTransition();
	TranslateTransition t2= new TranslateTransition();
	TranslateTransition t3 = new TranslateTransition();
	TranslateTransition ts = new TranslateTransition();
	AnimationTimer timer1;
	Timeline timeline1;
	Timeline timeline2;
	Timeline timeline3;
	@FXML private ImageView pause;
	@FXML
    private ImageView ExitButton;
    @FXML
    private ImageView UnmuteButton;
    @FXML
    private ImageView MuteButton;
    @FXML
    private ImageView SaveButton;
    @FXML
    private ImageView ResumeButton;
    @FXML
    void save(MouseEvent event) throws IOException {
    	ArrayList<Double> obstacleY = new ArrayList<Double>();
    	for(GameObject i: objects) {
    		obstacleY.add(i.getLocationY());
    	}
    	double ballY = ball.getCenterY();
    	double starY = s.getLocationY();
    	int score = stars;
//    	Color ballColor = ball.getColor();
    	GameObjects.State state = new GameObjects.State(obstacleY, starY, ballY, score);
    	state.addState();
    	state.serialize();
    	controller.sceneChanger.getHomeMenu(event);
    }
    @FXML
    void exit(MouseEvent event) {
    	try {
			controller.sceneChanger.getHomeMenu(event);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void Mute(ActionEvent event) {

    }
    @FXML
    void unmute(ActionEvent event) {
    	
    }
	
    @FXML
    public void initialize() {
    	StarText.setVisible(true);
    	MuteButton.setVisible(false);
    	UnmuteButton.setVisible(false);
    	ResumeButton.setVisible(false);
    	SaveButton.setVisible(false);
    	ExitButton.setVisible(false);
//    	pause.setVisible(true);
    	if(controller.currState==null) {
    		o1 = new CircleObstacle(pane, currY);
    		o2 = new Cross(pane, currY);
    		o3 = new Dash(pane, currY);
    		s = new Star(pane, currStarY);
    		objects.add(o1);
    		objects.add(o2);
    		objects.add(o3);
    		ball = new Ball(W/2, W/2, 8);
//    		int currY = 300;
//    		int currStarY = 250;
    		pane.getChildren().add(ball.getNode());		
    		createInitialBlocks();
    		
    		pane.setOnMousePressed(new EventHandler<MouseEvent>() {
    			@Override
    			public void handle(MouseEvent event) {
//    				if(event.getCode()==KeyCode.UP) {
    					controller.hitSpace=true;
//    				}
    			}
    		});
//    		new java.util.Timer().schedule(
//                  new java.util.TimerTask() {
//                      @Override
//                      public void run() {
//                    	  controller.removeUnwantedObject();
//                      }
//                  },1, 1);
    		
    		timeline1 = new Timeline(new KeyFrame(new Duration(100), actionEvent->{
    			removeUnwantedObject(objects);
    		}));
    		timeline1.setCycleCount(Animation.INDEFINITE);
    		timeline1.play();
    		
    		
    		timeline2 = new Timeline(new KeyFrame(new Duration(100), actionEvent->{
    			if(ball.getCenterY()<450) {
    				updateObjects();
    			}
    		}));
    		timeline2.setCycleCount(Animation.INDEFINITE);
    		timeline2.play();
    		
    		timeline3 = new Timeline(new KeyFrame(new Duration(100), actionEvent->{
    			if(ball.getCenterY()<s.getLocationY()+10) {
//    				controller.updateScore();
    				stars++;
    				s.collect();
    				currStarY = currStarY - 300;
    				s.relocate(W/2-20, currStarY);
    				s.place();
    			}
    		}));
    		timeline3.setCycleCount(Animation.INDEFINITE);
    		timeline3.play();
            
    		
            timer1 = new AnimationTimer() {
    			double myTime = 0.0;
    			double gravity = 15;
    			@Override
    			public void handle(long arg0) {
    				StarText.setText("" + stars);
    				double currY = ball.getCenterY();
    				velocityY += gravity*0.5*Math.pow(myTime, 2);
    				double deltaY = velocityY;
    				double newY = currY + deltaY;
    				
    				if(controller.hitSpace) {
    					velocityY =- 4;
    					myTime = .13;
    					controller.hitSpace = false;
    				}
    				
    				ball.setCenterY(newY);
    				if(checkGameOver(ball)) {
    					this.stop();
    					timeline1.stop();
    					timeline2.stop();
    					timeline3.stop();
    					gameOver();
    				}
    				myTime += .001;
    			}
    		};
    		timer1.start();
    	}
    	else {
    		o1 = new CircleObstacle(pane, (double)controller.currState.obstacleYArrayList.get(0));
    		System.out.println("abc");
    		o2 = new Cross(pane, (double)controller.currState.obstacleYArrayList.get(1));
    		o3 = new Dash(pane, (double)controller.currState.obstacleYArrayList.get(2));
    		s = new Star(pane, (double)controller.currState.starY);
    		objects.add(o1);
    		objects.add(o2);
    		objects.add(o3);
    		ball = new Ball(W/2, (double)controller.currState.ballY, 8);
    		pane.getChildren().add(ball.getNode());		
    		createInitialBlocks();
    		
    		pane.setOnMousePressed(new EventHandler<MouseEvent>() {
    			@Override
    			public void handle(MouseEvent event) {
//    				if(event.getCode()==KeyCode.UP) {
    					controller.hitSpace=true;
//    				}
    			}
    		});
//    		new java.util.Timer().schedule(
//                  new java.util.TimerTask() {
//                      @Override
//                      public void run() {
//                    	  controller.removeUnwantedObject();
//                      }
//                  },1, 1);
    		
    		timeline1 = new Timeline(new KeyFrame(new Duration(100), actionEvent->{
    			removeUnwantedObject(objects);
    		}));
    		timeline1.setCycleCount(Animation.INDEFINITE);
    		timeline1.play();
    		
    		
    		timeline2 = new Timeline(new KeyFrame(new Duration(100), actionEvent->{
    			if(ball.getCenterY()<450) {
    				updateObjects();
    			}
    		}));
    		timeline2.setCycleCount(Animation.INDEFINITE);
    		timeline2.play();
    		
    		timeline3 = new Timeline(new KeyFrame(new Duration(100), actionEvent->{
    			if(ball.getCenterY()<s.getLocationY()+10) {
//    				controller.updateScore();
    				stars++;
    				s.collect();
    				currStarY = currStarY - 300;
    				s.relocate(W/2-20, currStarY);
    				s.place();
    			}
    		}));
    		timeline3.setCycleCount(Animation.INDEFINITE);
    		timeline3.play();
            
    		
            timer1 = new AnimationTimer() {
    			double myTime = 0.0;
    			double gravity = 15;
    			@Override
    			public void handle(long arg0) {
    				StarText.setText("" + stars);
    				double currY = ball.getCenterY();
    				velocityY += gravity*0.5*Math.pow(myTime, 2);
    				double deltaY = velocityY;
    				double newY = currY + deltaY;
    				
    				if(controller.hitSpace) {
    					velocityY =- 4;
    					myTime = .13;
    					controller.hitSpace = false;
    				}
    				
    				ball.setCenterY(newY);
    				if(checkGameOver(ball)) {
    					this.stop();
    					timeline1.stop();
    					timeline2.stop();
    					timeline3.stop();
    					controller.currState=null;
    					gameOver();
    				}
    				myTime += .001;
    			}
    		};
    		timer1.start();
    	}	
    }
    
    private void createInitialBlocks() {
		o1.relocate(W/2-75, currY);
		currY= currY-300;
		o2.relocate(W/2-40, currY);
		currY = currY-300;
		o3.relocate(W/2, currY);
		currY = currY-300;
		s.relocate(W/2-20, currStarY);
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
		
		translate((Node)o1.getNode(), 0, (450-ball.getCenterY()), 1, 1000, false);
		translate((Node)o2.getNode(), 0, (450-ball.getCenterY()), 1, 1000, false);
		translate((Node)o3.getNode(), 0, (450-ball.getCenterY()), 1, 1000, false);
		translate((Node)s.getNode(), 0, (450-ball.getCenterY()), 1, 1000, false);
		
	}

	void translate(Node node,double x,double y,int cyclecount,double timeMilli,boolean reverse){
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
	
	@FXML
	private void PauseButton(Event event) {
		try {
			timer1.stop();
			timeline1.pause();
			timeline2.pause();
			timeline3.pause();
			pause.setVisible(false);
			MuteButton.setVisible(true);
//	    	UnmuteButton.setVisible(false);
	    	ResumeButton.setVisible(true);
	    	SaveButton.setVisible(true);
	    	ExitButton.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
    void Resume(MouseEvent event) {
    	System.out.println("resume called");
    	pause.setVisible(true);
		MuteButton.setVisible(false);
//    	UnmuteButton.setVisible(false);
    	ResumeButton.setVisible(false);
    	SaveButton.setVisible(false);
    	ExitButton.setVisible(false);
    	timer1.start();
    	timeline1.play();
    	timeline2.play();
    	timeline3.play();
    }
	
	public void removeUnwantedObject(ArrayList<GameObject> objects) {
    	for(GameObject i : objects) {
    		if(i.getNode().getBoundsInParent().getCenterY()>720) {
    			i.setMovedOffScreen(true);
    		}
    	}
    	for(GameObject i : objects) {
    		if(i.hasMovedOffScreen())
    			relocateObject(i);
    	}
    }
    
    public void relocateObject(GameObject i) {
    		currY = currY - 300;
    		i.getNode().setLayoutY(currY);
//    		currY = currY - 300;
        	i.setMovedOffScreen(false);
    }
}

