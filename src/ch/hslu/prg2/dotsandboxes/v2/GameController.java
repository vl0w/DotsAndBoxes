package ch.hslu.prg2.dotsandboxes.v2;

import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.GameModel;
import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.model.Move;
import ch.hslu.prg2.dotsandboxes.v2.view.GameViewListener;

public class GameController implements GameViewListener, GameModelListener {

	private Player localPlayer;
	private Player remotePlayer;
	private GameModel model;

	public GameController() {
		// TODO define constructor
	}

	@Override
	public void moveDone(GameBoard gameBoard, Move move) {
		// TODO check gamestate, notify players
	}

	@Override
	public void moveFailed(Move move) {
		// TODO check gamestate, notify players

	}

	@Override
	public void onLineSelected(Dot dotOne, Dot dotTwo) {
		Move move = new Move(dotOne, dotTwo, localPlayer.getColor());
		model.handleMove(move);
	}

}
