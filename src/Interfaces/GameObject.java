package Interfaces;

import Gui.Controller.Controller;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface GameObject {
    double getLocationX();
    
    double getLocationY();
    
    boolean hasMovedOffScreen();

    void setMovedOffScreen(boolean movedOffScreen);

    void setX(double x);

    void setY(double y);
    
    void updatePosition();
    
    Node getNode();

}
