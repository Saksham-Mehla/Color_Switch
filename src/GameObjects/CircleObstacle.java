package GameObjects;

import application.Position;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class CircleObstacle extends Obstacle{
	private RotateTransition rotate1;
	private final int radius = 75;
	private Shape a1;
	private Shape a2;
	private Shape a3;
	private Shape a4;
	private boolean movedOffScreen = false;
	
	public CircleObstacle(AnchorPane root, int y) {
		super(root);
		pos = new Position(640, y);
		rotate1 = new RotateTransition();
		rotate1.setByAngle(3600);
		rotate1.setDuration(Duration.seconds(30));
		rotate1.setCycleCount(Transition.INDEFINITE);
		Circle circle = new Circle(pos.getx(), pos.gety(), radius-10);	 
		Arc arc1 = new Arc();
		arc1.setCenterX(pos.getx());
		arc1.setCenterY(pos.gety());
		arc1.setRadiusX(radius);
		arc1.setRadiusY(radius);
		arc1.setStartAngle(0);
		arc1.setLength(90.0f);
		arc1.setType(ArcType.ROUND);
		arc1.setStrokeWidth(10);
		a1 = Shape.subtract(arc1,  circle);
		a1.setStroke(Color.MEDIUMPURPLE);
		a1.setFill(Color.MEDIUMPURPLE);
			 
		Arc arc2 = new Arc();
		arc2.setCenterX(pos.getx());
		arc2.setCenterY(pos.gety());
		arc2.setRadiusX(radius);
		arc2.setRadiusY(radius);
		arc2.setStartAngle(90);
		arc2.setLength(90.0f);
		arc2.setType(ArcType.ROUND);
		arc2.setStrokeWidth(8);
		a2 = Shape.subtract(arc2,  circle);
		a2.setStroke(Color.YELLOW);
		a2.setFill(Color.YELLOW);
		
		Arc arc3 = new Arc();
		arc3.setCenterX(pos.getx());
		arc3.setCenterY(pos.gety());
		arc3.setRadiusX(radius);
		arc3.setRadiusY(radius);
		arc3.setStartAngle(180);
		arc3.setLength(90.0f);
		arc3.setType(ArcType.ROUND);
		arc3.setStrokeWidth(8);
		a3 = Shape.subtract(arc3,  circle);
		a3.setStroke(Color.MAGENTA);
		a3.setFill(Color.MAGENTA);
		
		Arc arc4 = new Arc();
		arc4.setCenterX(pos.getx());
		arc4.setCenterY(pos.gety());
		arc4.setRadiusX(radius);
		arc4.setRadiusY(radius);
		arc4.setStartAngle(270);
		arc4.setLength(90.0f);
		arc4.setType(ArcType.ROUND);
		arc4.setStrokeWidth(8);
		a4 = Shape.subtract(arc4,  circle);
		a4.setStroke(Color.CYAN);
		a4.setFill(Color.CYAN);

	    g.getChildren().addAll(a1, a2, a3, a4);
	    root.getChildren().add(g);
	    rotate1.setNode(g);
		rotate();
	}
	
	public void rotate() {
		rotate1.play();
	}
	@Override
	public void pause() {
		rotate1.pause();
	}
	
	public boolean checkIntersect(Circle n, Bounds b) {
		Shape i1 = Shape.intersect(n, a1);
		Shape i2 = Shape.intersect(n, a2);
		Shape i3 = Shape.intersect(n, a3);
		Shape i4 = Shape.intersect(n, a4);
		
		
		if(i1.getBoundsInParent().getWidth()!=-1) {
			if(a1.getStroke() == n.getFill()) return false;
			else return true;
		}
		if(i2.getBoundsInParent().getWidth()!=-1) {
			if(a2.getStroke() == n.getFill()) return false;
			else return true;
		}
		if(i3.getBoundsInParent().getWidth()!=-1) {
			if(a3.getStroke()== n.getFill()) return false;
			else return true;
		}
		if(i4.getBoundsInParent().getWidth()!=-1) {
			if(a4.getStroke()== n.getFill()) return false;
			else return true;
		}
		return false;
	}

	@Override
	public double getLocationX() {
		return g.getLayoutX();
	}

	@Override
	public double getLocationY() {
		return g.getLayoutY();
	}

	@Override
	public boolean hasMovedOffScreen() {
		return movedOffScreen;
	}

	@Override
	public void setMovedOffScreen(boolean movedOffScreen) {
		this.movedOffScreen = movedOffScreen;
	}

	@Override
	public void setX(double x) {
		g.setLayoutX(x);
		
	}

	@Override
	public void setY(double y) {
		g.setLayoutY(y);
		
	}
	
	@Override
	public void updatePosition() {
		
	}
}
