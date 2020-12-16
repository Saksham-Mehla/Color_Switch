package Gui.Controller;

import Gui.SceneChanger;
import Interfaces.GameObject;
import Interfaces.Factory.ClassicMode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import GameObjects.CircleObstacle;
import GameObjects.Obstacle;
import GameObjects.Star;

public class Controller{
    private static final Controller ourInstance = new Controller();
    public final ArrayList<GameObject> objects = new ArrayList<>();
    public ClassicMode gameMode = new ClassicMode();
    public int score = 0;
    public int stars = 0;
    public boolean hitSpace = false;
    public String type;
    public int currY = 300;
    public int currStarY = 80;
    private final Random random = new Random();
    public boolean inGame = false;  

    public SceneChanger sceneChanger = SceneChanger.getInstance();

    public static Controller getInstance() {
        return ourInstance;
    }
    
    public void updateScore() {
    	stars++;
    }

    public GameObject getRandomObject(AnchorPane pane) {
        return gameMode.createObject(pane);
    }
    public void removeUnwantedObject() {
    	for(GameObject i : objects) {
    		if(i.getNode().getBoundsInParent().getCenterY()>720) {
    			i.setMovedOffScreen(true);
    		}
    	}
    	for(GameObject i : objects) {
    		if(i.hasMovedOffScreen())
    			relocateObject(i);
    	}
    }
    
    public void relocateObject(GameObject i) {
    		i.getNode().setLayoutY(currY);
    		currY = currY - 300;
        	i.setMovedOffScreen(false);
    	
    }

//    void getObjects(AnchorPane pane) {
//                  GameObject temp = getRandomObject(pane);
//                  objects.add(temp);
//    }
}
