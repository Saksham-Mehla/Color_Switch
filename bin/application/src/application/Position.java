package application;

public class Position implements Comparable<Position>{
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Position o) {
		int pos_o = o.gety();
		return this.y-pos_o;
	}
	
	
}
