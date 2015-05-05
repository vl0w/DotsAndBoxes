package ch.hslu.prg2.dotsandboxes.game;

public class Line {
	private Dot dot1;
	private Dot dot2;
	private PlayerColor color;
	
	public Line(Dot dot1, Dot dot2){
		this.dot1=dot1;
		this.dot2=dot2;
		this.color=PlayerColor.NONE;
	}
}
