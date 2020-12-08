package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.geometry.*; 
import javafx.scene.paint.*;
import javafx.scene.text.Font; 
import javafx.scene.control.Button;

public class SampleGame extends Application {
	int points = 0;;
	int nStars = 0;
	

	public SampleGame() {
		// TODO Auto-generated constructor stub
	}
	
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			String s1 = "Score: " + points;
			Label sc = new Label(s1);
			sc.setFont(Font.font("Nunito", 14));
			sc.setTextFill(Color.WHITE);
			String s2 = "Stars: " + nStars;
			Label ns=new Label(s2);
			ns.setFont(Font.font("Nunito", 14));
			ns.setTextFill(Color.WHITE);
			sc.setLayoutX(10);
			sc.setLayoutY(10);
			ns.setLayoutX(10);
			ns.setLayoutY(25);

			Button button= new Button("Pause");
			button.setLayoutX(540);
			button.setLayoutY(10);
			root.getChildren().add(sc);
			root.getChildren().add(ns);
			root.getChildren().add(button);
			
			BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY ); 
			Background background = new Background(background_fill); 
			root.setBackground(background);
			play(scene);
			primaryStage.setTitle("Color Switch");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play(Scene scene) {
		CircleObstacle o = new CircleObstacle();
		o.display((AnchorPane)scene.getRoot());
		Ball b = new Ball();
		b.display((AnchorPane)scene.getRoot());	     
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
