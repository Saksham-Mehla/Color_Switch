package Gui.Controller;

import java.io.IOException;

import GameObjects.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CreateNewGame {
	final Controller controller = Controller.getInstance();
    @FXML private Slider DifficultySlider;
    @FXML private ImageView PlayNew;
    @FXML private TextField NameField;
    @FXML private ImageView Back;
    private State state;

    @FXML
    void BackButton(MouseEvent event) {
    	try {
    		controller.sceneChanger.getHomeMenu(event);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void PlayNewButton(MouseEvent event) {
    	try {
    		controller.currState=null;
    		controller.currName = NameField.getText();
    		controller.sceneChanger.getClassic(event);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
