package GameObjects;
import application.Position;
import Interfaces.GameObject;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;

public abstract class Obstacle implements GameObject {

	protected Position pos;
	protected Group g;
	protected AnchorPane root;
	
	Obstacle(AnchorPane root){
		this.root = root;
		this.g = new Group();
	}
	
	public Position getPos() {
		return pos;
	}
	
	public abstract void pause();
	
	public abstract boolean checkIntersect(Circle n, Bounds b);
	
	public void relocate(double x, double y) {
		g.relocate(x, y);
	}
	
	public Group getNode() {
		return g;
	}	
	
}
