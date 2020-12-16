package application;

public class Position implements Comparable<Position>{
	private double x;
	private double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getx() {
		return x;
	}
	
	public double gety() {
		return y;
	}
	
	public void setPos(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Position o) {
		double pos_o = o.gety();
		return (int)(this.y-pos_o);
	}
	
	
}
