package Interfaces.Factory;

import Gui.Controller.Controller;
import Interfaces.GameObject;
import Interfaces.Strategy.GameMode;
import javafx.scene.layout.AnchorPane;
import java.util.Random;
import GameObjects.CircleObstacle;
import GameObjects.Cross;
import GameObjects.Dash;
import GameObjects.Star;

public class ClassicMode implements GameMode {
    private final Random rand = new Random();
    private final Controller controller = Controller.getInstance();

    public int getHighScore() {
//        return controller.usersDB.getHighestScore(1);
    	return 0;
    }

    public boolean validate(int score) {
//        return controller.usersDB.getPlayer().getClassicScore() < score;
    	return true;
    }



	@Override
	public GameObject createObject(AnchorPane pane) {
		int flag = rand.nextInt(5) % 4;

        switch (flag) {
            case 0:
                return new CircleObstacle(pane, controller.currY);
            case 1:
                return new CircleObstacle(pane, controller.currY);
            case 2:
                return new Dash(pane, controller.currY);
            case 3:
                return new Cross(pane, controller.currY);
            case 4:
                return new Cross(pane, controller.currY);
        }
        return null;
	}
}
