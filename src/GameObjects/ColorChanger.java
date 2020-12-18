package GameObjects;

import Interfaces.GameObject;
import application.Position;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ColorChanger implements GameObject {
	protected AnchorPane root;
	protected Position pos;
	protected boolean movedOffScreen = false;
	protected ImageView img;
	public ColorChanger(AnchorPane root, double y){
		this.root = root;
		pos = new Position(620, y);
		img = new ImageView();
		img.setImage(new Image(this.getClass().getResourceAsStream("cc.jpg"), 50, 50, !movedOffScreen, !movedOffScreen));
		img.setLayoutX(620);
		img.setLayoutY(y+50);
		root.getChildren().add(img);
	}

	public double getLocationY() {
		return img.getBoundsInParent().getCenterY();
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
		return 620;
	}

	@Override
	public void setX(double x) {
	}

	public void relocate(double x, double y) {
		img.relocate(x, y);	
	}

	public void collect() {
		img.setVisible(false);
	}

	public void place() {
		img.setVisible(true);
	}
}
