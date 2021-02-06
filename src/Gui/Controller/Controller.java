package Gui.Controller;

import Gui.SceneChanger;
import GameObjects.State;
import java.util.Random;

public class Controller{
    private static final Controller ourInstance = new Controller();
    public State currState;
    public String currName;
    public boolean hitSpace = false;
    public String type;
    public final Random random = new Random();
    public boolean inGame = false;  
    public boolean soundon = true;

    public SceneChanger sceneChanger = SceneChanger.getInstance();

    public static Controller getInstance() {
        return ourInstance;
    }
}
