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

	@Override
	public String toString() {
		return "x: " + getX() + " y: " + getY();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Dot) {
			Dot other = (Dot) obj;
			return this.x == other.x && this.y == other.y;
		}
		return false;
	};

	@Override
	public int hashCode() {
		return 7 * this.x + 23 * this.y;
	}
}
