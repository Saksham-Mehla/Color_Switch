package Interfaces.Strategy;

import Interfaces.GameObject;
import javafx.scene.layout.AnchorPane;

public interface GameMode {
    GameObject createObject(AnchorPane pane);

    int getHighScore();

    boolean validate(int score);
}
