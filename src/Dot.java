

public class Dot {
	private int x;
	private int y;
	private Player owner;
	
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
	
	public void setOwner(Player owner){
		this.owner = owner;
		changeColor(owner);
	}
	private void changeColor(Player owner){
		switch(owner.getId()){
		case 1: {color = blue;break;}
		case 2: {color = red; break;}
		default: {color = white;break;}
		}
		}
	}

}
