package GameObjects;

import Interfaces.GameObject;
import application.Position;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Star implements GameObject{
	protected AnchorPane root;
	protected Position pos;
	protected boolean movedOffScreen = false;
	protected ImageView img;
	public Star(AnchorPane root, int y){
		this.root = root;
		pos = new Position(635, y);
		img = new ImageView();
		img.setImage(new Image(this.getClass().getResourceAsStream("star.jpg"), 50, 50, !movedOffScreen, !movedOffScreen));
		img.setLayoutX(620);
		img.setLayoutY(y+50);
		root.getChildren().add(img);
	}

	public double getLocationY() {
		return img.getLayoutY();
	}

	public boolean hasMovedOffScreen() {
		return movedOffScreen;
	}

	public void setMovedOffScreen(boolean movedOffScreen) {
		this.movedOffScreen = movedOffScreen;
	}

	public void setY(double y) {
		pos.setPos(pos.getx(), (int)y);
	}

	public void updatePosition() {
		
	}
	public ImageView getNode(){
		return img;
	}

	@Override
	public double getLocationX() {
		return 640;
	}

	@Override
	public void setX(double x) {
	}

	public void relocate(double x, double y) {
		img.relocate(x, y);	
	}

}
