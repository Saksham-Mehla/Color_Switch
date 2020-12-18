package Gui.Controller;

import java.io.IOException;
import java.util.ArrayList;
import GameObjects.State;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoadGame {
	final Controller controller = Controller.getInstance();
	public State state;
	
    @FXML private ImageView LoadButton;
    @FXML private ImageView BackButton;
    @FXML private ListView<String> GamesList;
    public ArrayList<State> list;
    public int index;
    
    @FXML
    void initialize() throws ClassNotFoundException, IOException{
    	state = new State();
       	GamesList.setEditable(true);
    	list = state.deserialize();
       	int counter = 0;
    	
    	for(State i : list) {
    		counter++;
    		GamesList.getItems().add("Load Game " + counter + " Stars:" + i.score);
    	}
    }
    @FXML
    void LoadGameClassic(MouseEvent event) {
    	try {
			controller.currState = list.get(GamesList.getSelectionModel().getSelectedIndex());
			controller.sceneChanger.getClassic(event);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void BackToHome(MouseEvent event) {
    	try {
    		controller.sceneChanger.getHomeMenu(event);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

}
