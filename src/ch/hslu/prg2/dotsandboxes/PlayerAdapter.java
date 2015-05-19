package ch.hslu.prg2.dotsandboxes;

import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public class PlayerAdapter implements Player {

	private PlayerColor color;

	public PlayerAdapter(PlayerColor color) {
		this.color = color;
	}

	@Override
	public void gameEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void yourTurn(GameBoard gameBoard) {
		// TODO Auto-generated method stub

	}

	@Override
	public void opponentTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerColor getPlayerColor() {
		return color;
	}

}
