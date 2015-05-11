package ch.hslu.prg2.dotsandboxes.game;

public class Move {
	private Dot dotOne;
	private Dot dotTwo;
	private PlayerColor owner;

	public Move(Dot dotOne, Dot dotTwo) {
		this.dotOne = dotOne;
		this.dotTwo = dotTwo;
	}
	public Dot getDot1(){
		return dotOne;
	}
	public Dot getDot2(){
		return dotTwo;
	}
	public PlayerColor getPlayerColor(){
		return owner;
	}
}
