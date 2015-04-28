package ch.hslu.prg2.dotsandboxes;

public class Dot {
	private int x;
	private int y;
	private PlayerColor owner;

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

	public void setOwner(PlayerColor owner) {
		this.owner = owner;
	}
}
