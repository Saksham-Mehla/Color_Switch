package Gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import application.BackGround;

public class SceneChanger {
    private static SceneChanger instance = new SceneChanger();
    Scene scene = null;
    Stage stage = null;
    Parent root = null;

    public static SceneChanger getInstance() {
        return instance;
    }
    
    public void getClassic(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FxmlFiles/Classic.fxml"));
        scene = new Scene(root, 1280, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void getHomeMenu(Event event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("FxmlFiles/HomeMenu.fxml"));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void getCreateNewMenu(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("FxmlFiles/CreateNewGame.fxml"));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void getLoadGameMenu(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("FxmlFiles/SelectSavedGame.fxml"));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void getonExit(Event event) throws Exception{
		root = FXMLLoader.load(getClass().getResource("FxmlFiles/OnExit.fxml"));
		Scene scene = new Scene(root, 600, 400);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
	}
    public void getGameOver(Event event) throws Exception{
		root = FXMLLoader.load(getClass().getResource("FxmlFiles/GameOver.fxml"));
		Scene scene = new Scene(root, 600, 400);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
	}
    public void getPauseMenu(Event event) throws Exception{
		root = FXMLLoader.load(getClass().getResource("FxmlFiles/PauseMenu.fxml"));
		Scene scene = new Scene(root, 600, 400);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
	}
    public Scene getScene() {
    	return scene;
    }
}
