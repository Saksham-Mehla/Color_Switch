package GameObjects;

import Gui.Controller.Controller;
import Interfaces.GameObject;
import application.Position;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball implements GameObject{
	final Controller controller = Controller.getInstance();
	private int radius= 7;
	private Position pos = new Position(640, 640);
	private Color color;
	private Circle circle;
	
	public Ball(double x, double y, int radius) {
		pos.setPos(x, y);
		this.radius = radius;
		circle = new Circle(pos.getx(), pos.gety(), this.radius);
		circle.setFill(Color.YELLOW);
	}
	
	public void jump() {
		
	}
	
	public void fall() {
		
	}
	
	public Position getPos() {
		return pos;
	}
	
	public void changeColor() {
		int x = controller.random.nextInt(4);
		Color c;
<<<<<<< HEAD
		if(x==0) c = Color.MEDIUMPURPLE;
		else if(x==1) c = Color.YELLOW;
		else if(x==2) c = Color.MAGENTA;
		else c = Color.CYAN;
=======
		if(x==0)
			c = Color.MEDIUMPURPLE;
		else if(x==1)
			c = Color.YELLOW;
		else if(x==2)
			c = Color.CYAN;
		else if(x==4)
			c = Color.MAGENTA;
		else c = Color.WHITE;
>>>>>>> 8d27990bd3dfd5fd3de0b69d40fbfa6b056e54ac
		circle.setFill(c);
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int r) {
		radius = r;
		circle.setRadius(r);
	}	
	
	public void display(AnchorPane root) {
		root.getChildren().add(this.circle);
	}

	@Override
	public double getLocationX() {
		return pos.getx();
	}

	@Override
	public double getLocationY() {
		return pos.gety();
	}

	@Override
	public void setMovedOffScreen(boolean movedOffScreen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasMovedOffScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return circle;
	}

	public double getCenterY() {
		return circle.getCenterY();
	}

	public void setCenterY(double newY) {
		circle.setCenterY(newY);
		
	}

	public Bounds getBoundsInParent() {
		return circle.getBoundsInParent();
	}
}
