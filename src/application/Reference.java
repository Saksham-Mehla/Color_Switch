package application;

import GameObjects.CircleObstacle;
import GameObjects.Cross;
import GameObjects.Dash;
import GameObjects.Obstacle;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Reference extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	Obstacle o1;
	Obstacle o2;
	Obstacle o3;
	Circle ball;
	private AnchorPane root;
	private int H = 720;
	private int W = 1280;
	private boolean hitSpace = false;
	double velocityY = 0;
	TranslateTransition t = new TranslateTransition();
	
	private Circle createCircle() {
		Circle ball = new Circle(W/2, W/2, 8, Color.YELLOW);
		return ball;
	}
	
	public void start(Stage stage) throws Exception{
		root = new AnchorPane();
		o1 = new CircleObstacle(root);
		o2 = new Cross(root);
		o3 = new Dash(root);
		ball = createCircle();
		root.getChildren().add(ball);
		
		createInitialBlocks();
		
		Scene scene = new Scene(root, W, H, Color.BLACK);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.SPACE) {
					hitSpace=true;
					
				}
			}
		});
		
		AnimationTimer timer = new AnimationTimer() {
			double myTime = 0.0;
			double gravity = 9.8;
			@Override
			public void handle(long arg0) {
				double currY = ball.getCenterY();
				velocityY += gravity*0.5*Math.pow(myTime, 2);
				double deltaY = velocityY;
				double newY = currY + deltaY;
				if(hitSpace) {
					velocityY =-3.5;
					myTime = .13;
					hitSpace = false;
				}
				ball.setCenterY(newY);
				if(checkGameOver(ball)) {
					this.stop();
					gameOver();
				}
				myTime += .001;
			}
		};
		timer.start();
		
		stage.setScene(scene);
		stage.show();
	}
	
	private void createInitialBlocks() {
		o1.relocate(W/2-75, 100);
		o2.relocate(W/2-40, 300);
		o3.relocate(W/2, 500);
	}
	
	private boolean checkGameOver(Circle icon) {
		if(o1.checkIntersect(icon, icon.getBoundsInParent())) return true;
		if(o2.checkIntersect(icon, icon.getBoundsInParent())) return true;
		if(o3.checkIntersect(icon, icon.getBoundsInParent())) return true;
		return false;
	}
	
	private void gameOver() {
		Text gameOver = new Text(W/2-50, H/2, "Game Over!");
		gameOver.setFill(Color.RED);
		gameOver.setFont(Font.font("Verdana", 20));
		root.getChildren().add(gameOver);
	}	
}
