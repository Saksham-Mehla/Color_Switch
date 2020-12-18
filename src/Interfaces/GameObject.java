package Interfaces;

import javafx.scene.Node;

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
