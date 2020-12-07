package application;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.*; 

public class BackGround {
	private Color color;
	private Background bg;
	public BackGround(Color color) {
		this.color = color;
		BackgroundFill background_fill = new BackgroundFill(this.color, CornerRadii.EMPTY, Insets.EMPTY ); 
		bg = new Background(background_fill); 
	}
	
	public void changeColor(Color c) {
		color = c;
		BackgroundFill background_fill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY );
		bg = new Background(background_fill);
	}
	
	public Color getColor() {
		return color;
	}
	
	public Background getBg() {
		return bg;
	}
	
}
