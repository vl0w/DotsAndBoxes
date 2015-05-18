package ch.hslu.prg2.dotsandboxes.model;

public class Dot {
	private int x;
	private int y;

	public Dot(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(){
		return "x: "+getX()+" y: "+getY();
		
	}
}