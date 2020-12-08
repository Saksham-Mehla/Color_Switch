package application;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;

class Dash extends Obstacle{
	private int translationSpeed;
	
	public Dash() {
		
	}
	
	public int getTS() {
		return translationSpeed;
	}
	
	public void incTS() {
		
	}
}

class Cross extends Obstacle{
	
}

class CircleObstacle extends Obstacle{
	private Arc arc1;
	private Arc arc2;
	private Arc arc3;
	private Arc arc4;
	
	public CircleObstacle() {
		arc1 = new Arc();
		arc2 = new Arc();
		arc3 = new Arc();
		arc4 = new Arc();
	}
	
	public void rotate() {
		
	}
	
	@Override
	public void display(AnchorPane root) {        
		Circle circle = new Circle(300.0f, 100.f, 42);
		final long startNanoTime = System.nanoTime();
		 
	    new AnimationTimer()
	    {
	        public void handle(long currentNanoTime)
	        {
	            double t = (currentNanoTime - startNanoTime) / 8000000.0; 
	            Rotate rotate = new Rotate(t, 300, 100);
	            
	    		arc1.setCenterX(300.0f);
	    		arc1.setCenterY(100.0f);
	    		arc1.setRadiusX(50.0f);
	    		arc1.setRadiusY(50.0f);
	    		arc1.setStartAngle(0);
	    		arc1.setLength(90.0f);
	    		arc1.setType(ArcType.ROUND);
	    		arc1.setStrokeWidth(8);
	    		Shape a1 = Shape.subtract(arc1,  circle);
	    		a1.setStroke(Color.YELLOW);
	    		a1.setFill(Color.YELLOW);
	    		root.getChildren().add(a1);
	    		a1.getTransforms().add(rotate);
	    		
	    		arc2.setCenterX(300.0f);
	    		arc2.setCenterY(100.0f);
	    		arc2.setRadiusX(50.0f);
	    		arc2.setRadiusY(50.0f);
	    		arc2.setStartAngle(90.0f);
	    		arc2.setLength(90.0f);
	    		arc2.setType(ArcType.ROUND);
	    		arc2.setStrokeWidth(8);
	    		Shape a2 = Shape.subtract(arc2,  circle);
	    		a2.setStroke(Color.CYAN);
	    		a2.setFill(Color.CYAN);
	    		root.getChildren().add(a2);
	    		a2.getTransforms().add(rotate);
	    		
	    		arc3.setCenterX(300.0f);
	    		arc3.setCenterY(100.0f);
	    		arc3.setRadiusX(50.0f);
	    		arc3.setRadiusY(50.0f);
	    		arc3.setStartAngle(180.0f);
	    		arc3.setLength(90.0f);
	    		arc3.setType(ArcType.ROUND);
	    		arc3.setStrokeWidth(8);
	    		Shape a3 = Shape.subtract(arc3,  circle);
	    		a3.setStroke(Color.MEDIUMPURPLE);
	    		a3.setFill(Color.MEDIUMPURPLE);
	    		root.getChildren().add(a3);
	    		a3.getTransforms().add(rotate);
	    	
	    		arc4.setCenterX(300.0f);
	    		arc4.setCenterY(100.0f);
	    		arc4.setRadiusX(50.0f);
	    		arc4.setRadiusY(50.0f);
	    		arc4.setStartAngle(270.0f);
	    		arc4.setLength(90.0f);
	    		arc4.setType(ArcType.ROUND);
	    		arc4.setStrokeWidth(8);
	    		Shape a4 = Shape.subtract(arc4,  circle);
	    		a4.setStroke(Color.RED);
	    		a4.setFill(Color.RED);
	    		root.getChildren().add(a4);
	    		a4.getTransforms().add(rotate);
	           
	        }
	    }.start();
	}
	
}

class Diamond extends Obstacle{
	
}

public abstract class Obstacle {

	protected Position pos;
	protected int rotationSpeed;
	
	public Position getPos() {
		return pos;
	}
	
	public int getRS() {
		return rotationSpeed;
	}
	
	public void increaseRS() {
		
	}
	
	public void display(AnchorPane root) {
		
	}

}
