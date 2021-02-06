package Gui.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu {
	 final Controller controller = Controller.getInstance();
	 @FXML private AnchorPane InstructionsPane;


	    @FXML
	    private ImageView Instructions;

	    @FXML
	    private ImageView speakerOff;

	    @FXML
	    private ImageView LoadGameButton;

	    @FXML
	    private ImageView SoundOn;

	    @FXML
	    private ImageView NewGameButton;

	    @FXML
	    private ImageView InstructionsBack;


	    @FXML
	    void speakerOff(MouseEvent event) {
	    	speakerOff.setVisible(false);
	    	SoundOn.setVisible(true);
	    	controller.soundon = false;
	    }

	    @FXML
	    void SoundOn(MouseEvent event) {
	    	speakerOff.setVisible(true);
	    	SoundOn.setVisible(false);
	    	controller.soundon = false;
	    }

	    

	    @FXML
	    void InstructionsButton(MouseEvent event) {
	    	
	    	InstructionsPane.setVisible(true);
	    }

	    @FXML
	    void InstructionsBack(MouseEvent event) {
	    	InstructionsPane.setVisible(false);
	    }


 
 @FXML
 void NewGameButton(MouseEvent event) {
// 	controller.settings.getSounds().getMainTheme().stop();
// 	controller.playSound("press", 0);
 	try {
 		controller.sceneChanger.getCreateNewMenu(event);
 	} catch (IOException e) {
 		e.printStackTrace();
 	}
 }

 @FXML
 void LoadGameButton(MouseEvent event) {
//   controller.settings.getSounds().getMainTheme().stop();
//   controller.playSound("press", 0);
   try {
	   controller.sceneChanger.getLoadGameMenu(event);
   } catch (IOException e) {
       e.printStackTrace();
   }
 }
@FXML
void initialize() {
	InstructionsPane.setVisible(false);
	speakerOff.setVisible(true);
	SoundOn.setVisible(false);
 

}
}
