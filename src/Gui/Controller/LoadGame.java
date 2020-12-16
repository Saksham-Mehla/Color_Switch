package Gui.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoadGame {
	final Controller controller = Controller.getInstance();
    @FXML private Button LoadButton;
    @FXML private Button BackButton;

    @FXML
    void LoadGameClassic(ActionEvent event) {
    	
    }

    @FXML
    void BackToHome(ActionEvent event) {
    	try {
    		controller.sceneChanger.getHomeMenu(event);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

}
