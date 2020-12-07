package application;
import javafx.scene.paint.Color;

public class Game {
	private String userName;
	private int points = 0;
	private int nStars = 0;
	private int difficulty;
	private BackGround bg;
	private int revivePenalty = 5;
	private Ball ball;
	
	public Game() {
		ball = new Ball();
		bg = new BackGround(Color.BLACK);
	}
	
	public void askToPlay() {
		play();
	}
	
	public void pause() {
		
	}
	
	public void play() {
		
	}
	
	protected void changeBg(Color c) {
		bg = new BackGround(c);
	}

	public void changeDifficulty(int d) {
		
	}
	
	public int getRevPenalty() {
		return revivePenalty;
	}
	
	protected void incRevPenalty() {
		
	}
	
	public int getnStars() {
		return nStars;
	}
	
	protected void setnStars(int n) {
		
	}
	
	public void setName(String n) {
		userName = n;
	}
	
	public String getName() {
		return userName;
	}
	
	protected void addStar() {
		
	}
	
	protected void addObstacle(Position currPos) {
		
	}
	
	public Ball getBall() {
		return ball;
	}
	
	
}
