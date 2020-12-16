package Gui.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class CreateNewGame {
	final Controller controller = Controller.getInstance();
    @FXML private Slider DifficultySlider;
    @FXML private Button PlayNew;
    @FXML private TextField NameField;
    @FXML private Button Back;

    @FXML
    void BackButton(ActionEvent event) {
    	try {
    		controller.sceneChanger.getHomeMenu(event);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void PlayNewButton(ActionEvent event) {
    	try {
    		controller.sceneChanger.getClassic(event);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
