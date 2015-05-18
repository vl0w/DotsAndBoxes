package ch.hslu.prg2.dotsandboxes.model;

import java.io.Serializable;

public class Move implements Serializable {
	private Dot dotOne;
	private Dot dotTwo;
	private PlayerColor owner;

	public Move(Dot dotOne, Dot dotTwo, PlayerColor owner) {
		this.dotOne = dotOne;
		this.dotTwo = dotTwo;
		this.owner = owner;
	}

	public Dot getDot1() {
		return dotOne;
	}

	public Dot getDot2() {
		return dotTwo;
	}

	public PlayerColor getPlayerColor() {
		return owner;
	}
}
