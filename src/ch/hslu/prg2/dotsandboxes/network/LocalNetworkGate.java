package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.model.Move;
import ch.hslu.prg2.dotsandboxes.model.MoveResult;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public class LocalNetworkGate implements Player, GameModelListener {

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
	public PlayerColor getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveDone(GameBoard gameBoard, MoveResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveFailed(Move move) {
		// TODO Auto-generated method stub

	}

}
