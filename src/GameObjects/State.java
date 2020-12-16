package GameObjects;
import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class State implements Serializable{
	public ArrayList<Double> obstacleYArrayList=new ArrayList<Double>();
	public static ArrayList<State> stateList;
	public double starY = 0;
	public int score = 0;
//	private Color color;
	public double ballY = 640;
	public State() {
		try {
			stateList = deserialize();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public State(ArrayList<Double> ObstacleY, double StarY, double BallY, int score) {
		obstacleYArrayList = ObstacleY;
		starY=StarY;
//		this.color=color;
		ballY=BallY;
//		stateList.add(this);
		this.score=score;
		try {
			stateList = deserialize();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void serialize() throws IOException {
		ArrayList<State> s1 = stateList;
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream (new FileOutputStream("out.txt"));
			out.writeObject(s1);
		} finally {
			out.close();
		}
	}
	public static ArrayList<State> deserialize() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		ArrayList<State> s1;
		in = new ObjectInputStream (new FileInputStream("out.txt"));
		s1 = (ArrayList<State>)in.readObject();
		in.close();
		return s1;
		
	}
	public ArrayList<State> getStates(){
		return stateList;
	}
	
	public void addState() {
		stateList.add(this);
	}
}