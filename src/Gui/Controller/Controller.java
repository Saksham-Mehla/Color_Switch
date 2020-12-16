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
import GameObjects.State;

public class Controller{
    private static final Controller ourInstance = new Controller();
    public ClassicMode gameMode = new ClassicMode();
    public State currState;
    public boolean hitSpace = false;
    public String type;
    private final Random random = new Random();
    public boolean inGame = false;  

    public SceneChanger sceneChanger = SceneChanger.getInstance();

    public static Controller getInstance() {
        return ourInstance;
    }

    public GameObject getRandomObject(AnchorPane pane) {
        return gameMode.createObject(pane);
    }
}
