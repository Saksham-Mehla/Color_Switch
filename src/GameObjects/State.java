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
	private static ArrayList<ArrayList<Integer>> obstacleYArrayList=new ArrayList<ArrayList<Integer>>();
	private static double starY;
	private static Color color;
	private static double ballY;
	public State(ArrayList<Integer> ObstacleY, int StarY, Color color, int BallY) {
		obstacleYArrayList.add(ObstacleY);
		starY=StarY;
		this.color=color;
		ballY=BallY;
	}
	public static void serialize(ArrayList<Integer> ObstacleY, int StarY, Color color, int BallY) throws IOException {
		State s1 = new State(ObstacleY, StarY, color, BallY);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream (new FileOutputStream("out.txt"));
			out.writeObject(s1);
		} finally {
			out.close();
		}
	}
	public static void deserialize() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (new FileInputStream("out.txt"));
			State s1 = (State)in.readObject();
		} finally {
			in.close();
		} 
	}
}
