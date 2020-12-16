package Gui.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu {

//    private boolean selected = false;

//    @FXML private ImageView new_game_img;
//    @FXML private ImageView load_game_img;
    final Controller controller = Controller.getInstance();
    @FXML private Button NewGameButton;
    @FXML private Button LoadGameButton;
    
    @FXML
    void NewGameButton(ActionEvent event) {
//    	controller.settings.getSounds().getMainTheme().stop();
//    	controller.playSound("press", 0);
    	try {
    		controller.sceneChanger.getCreateNewMenu(event);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void LoadGameButton(ActionEvent event) {
//      controller.settings.getSounds().getMainTheme().stop();
//      controller.playSound("press", 0);
      try {
   	   controller.sceneChanger.getLoadGameMenu(event);
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        NewGameButton.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 16));
//        LoadGameButton.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 16));
//
//
//        new_game_img.setOnMouseDragged((event) -> {
//    	   if(!selected) {
//    		   selected = true;
//    		   new_game_img.setVisible(false);
//               controller.settings.getSounds().getMainTheme().stop();
//               controller.playSound("slice", 0);
//                    try {
//                        controller.sceneChanger.getCreateNewMenu(event);
//                    } catch (IOException e) {
//						e.printStackTrace();
//					}
//    	   }
//       });
//
//        load_game_img.setOnMouseDragged((event) -> {
//    	   if(!selected) {
//    		   selected = true;
//    		   load_game_img.setVisible(false);
//               controller.settings.getSounds().getMainTheme().stop();
//               controller.playSound("slice", 0);
//                   try {
//                       controller.sceneChanger.getLoadGameMenu(event);
//    			   } catch (IOException e) {
//    				   e.printStackTrace();
//    			   }
//    	   }
//       });
//       NewGameButton.setOnMouseClicked(event -> {
//            controller.settings.getSounds().getMainTheme().stop();
//            controller.playSound("press", 0);
//            try {
//         	   controller.sceneChanger.getCreateNewMenu(event);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//       LoadGameButton.setOnMouseClicked(event -> {
//           controller.settings.getSounds().getMainTheme().stop();
//           controller.playSound("press", 0);
//           try {
//        	   controller.sceneChanger.getLoadGameMenu(event);
//           } catch (IOException e) {
//               e.printStackTrace();
//           }
//       });
//    }

//    public void loadButton(){
//        controller.playSound("press", 0);
//        TranslateTransition ngb=new TranslateTransition(new Duration(1000),new_game_img);
//        TranslateTransition lgb= new TranslateTransition(new Duration(1000),load_game_img);
//        ngb.setByX(270);
//        lgb.setByX(180);
//        lgb.play();
//        ngb.play();
//        ngb.setOnFinished(event -> LoadGameButton.setDisable(true));
//    }


}
