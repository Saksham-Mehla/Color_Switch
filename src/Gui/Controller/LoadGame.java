package Gui.Controller;

import java.io.IOException;
import java.util.ArrayList;

import GameObjects.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoadGame {
	final Controller controller = Controller.getInstance();
	public State state;
	
    @FXML private Button LoadButton;
    @FXML private Button BackButton;

    @FXML
    void LoadGameClassic(ActionEvent event) {
    	State state = new State();
    	ArrayList<State> list = new ArrayList<State>();
    	try {
			list = state.deserialize();
			int count = 0;
			for(State i : list) {
				count++;
				if(count==1) {
					
				}
				else {
					System.out.println(list.size());
					System.out.println(count + " " + i.score);
					controller.currState = i;
					break;
				}
				
			}
			if(list.size()>0) {
				controller.sceneChanger.getClassic(event);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
