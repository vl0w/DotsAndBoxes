package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.model.Move;
import ch.hslu.prg2.dotsandboxes.model.MoveResult;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

/**
 * @author Hyunkyo Suh, Jonas Hansen
 */
public class LocalNetworkGate implements Player, GameModelListener {
	PlayerColor playerColor;
	Move move;

	@Override
	public void gameEnded() {
		// notify local opponent
	}

	@Override
	public void yourTurn(GameBoard gameBoard) {
		move
	}

	@Override
	public void opponentTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerColor getColor() {
		return PlayerColor.valueOf();
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
