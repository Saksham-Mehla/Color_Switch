package GameObjects;

import application.Position;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Dash extends Obstacle{
	private TranslateTransition translate1;
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;
	private boolean movedOffScreen;
	
	public Dash(AnchorPane root, int y) {
		super(root);
		pos = new Position(10, y);
		translate1 = new TranslateTransition();
		translate1.setDuration(Duration.seconds(4));
		translate1.setFromX(-630);
		translate1.setToX(-10);
		translate1.setCycleCount(Transition.INDEFINITE);
		translate1.setAutoReverse(true);
		l1 = new Line();
		l2 = new Line();
		l3 = new Line();
		l4 = new Line();
			l1.setStartX(10);
			l1.setStartY(pos.gety());
			l1.setEndX(160);
			l1.setEndY(pos.gety());
			l1.setStrokeWidth(20);
			l1.setStroke(Color.MEDIUMPURPLE);
			
			l2.setStartX(170);
			l2.setStartY(pos.gety());
			l2.setEndX(320);
			l2.setEndY(pos.gety());
			l2.setStrokeWidth(20);
			l2.setStroke(Color.YELLOW);
			
			l3.setStartX(330);
			l3.setStartY(pos.gety());
			l3.setEndX(480);
			l3.setEndY(pos.gety());
			l3.setStrokeWidth(20);
			l3.setStroke(Color.MAGENTA);
			
			l4.setStartX(490);
			l4.setStartY(pos.gety());
			l4.setEndX(640);
			l4.setEndY(pos.gety());
			l4.setStrokeWidth(20);
			l4.setStroke(Color.CYAN);

		g.getChildren().addAll(l1, l2, l3, l4);
	    root.getChildren().add(g);
	    translate1.setNode(g);
		translate();
	}
	public void translate() {
		translate1.play();
	}
	@Override
	public void pause() {
		translate1.pause();
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