package application;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
	private int radius= 10;
	private Position pos = new Position(300, 350);
	private Color color;
	private Circle circle;
	
	public Ball() {
		circle = new Circle(pos.getx(), pos.gety(), radius);
		circle.setFill(Color.YELLOW);
	}
	
	public void jump() {
		int ycoordinate = pos.gety();
		pos.setPos(pos.getx(), ycoordinate+10);
	}
	
	public void fall() {
		int ycoordinate = pos.gety();
		pos.setPos(pos.getx(), ycoordinate-10);
	}
	
	public Position getPos() {
		return pos;
	}
	
	public void changeColor(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int r) {
		radius = r;
	}	
	
	public void display(AnchorPane root) {
		root.getChildren().add(this.circle);
	}
	
	public void blast(AnchorPane root) {
		
		
	}

}
