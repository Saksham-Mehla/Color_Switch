package GameObjects;

import application.Position;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Cross extends Obstacle{
	private RotateTransition rotate1;
	private final int radius = 80;
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;
	private boolean movedOffScreen;
	public Cross(AnchorPane root, int y) {
		super(root);
		pos = new Position(600, y);
		rotate1 = new RotateTransition();
		rotate1.setByAngle(3600);
		rotate1.setDuration(Duration.seconds(30));
		rotate1.setCycleCount(Transition.INDEFINITE);
		l1 = new Line();
		l2 = new Line();
		l3 = new Line();
		l4 = new Line();
			l1.setStartX(360);
			l1.setStartY(pos.gety());
			l1.setEndX(360+radius);
			l1.setEndY(pos.gety());
			l1.setStrokeWidth(12);
			l1.setStroke(Color.MEDIUMPURPLE);
			
			l2.setStartX(350);
			l2.setStartY(pos.gety()-10);
			l2.setEndX(350);
			l2.setEndY(pos.gety()-radius-10);
			l2.setStrokeWidth(12);
			l2.setStroke(Color.YELLOW);

			l3.setStartX(340);
			l3.setStartY(pos.gety());
			l3.setEndX(340-radius);
			l3.setEndY(pos.gety());
			l3.setStrokeWidth(12);
			l3.setStroke(Color.MAGENTA);

			l4.setStartX(350);
			l4.setStartY(pos.gety()+10);
			l4.setEndX(350);
			l4.setEndY(pos.gety()+radius+10);
			l4.setStrokeWidth(12);
			l4.setStroke(Color.CYAN);

//			g = new Group();
		    g.getChildren().addAll(l1, l2, l3, l4);
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
	
	@Override
	public boolean checkIntersect(Circle n, Bounds b) {
		Shape i1 = Shape.intersect(n, l1);
		Shape i2 = Shape.intersect(n, l2);
		Shape i3 = Shape.intersect(n, l3);
		Shape i4 = Shape.intersect(n, l4);
		
		
		if(i1.getBoundsInParent().getWidth()!=-1) {
			if(l1.getStroke() == n.getFill()) return false;
			else return true;
		}
		if(i2.getBoundsInParent().getWidth()!=-1) {
			if(l2.getStroke() == n.getFill()) return false;
			else return true;
		}
		if(i3.getBoundsInParent().getWidth()!=-1) {
			if(l3.getStroke()== n.getFill()) return false;
			else return true;
		}
		if(i4.getBoundsInParent().getWidth()!=-1) {
			if(l4.getStroke()== n.getFill()) return false;
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