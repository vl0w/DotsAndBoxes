package ch.hslu.prg2.dotsandboxes.v2;

import ch.hslu.prg2.dotsandboxes.game.Dot;
import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;
import ch.hslu.prg2.dotsandboxes.v2.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.v2.view.GameViewListener;

public class GameController implements GameViewListener, GameModelListener {

	private LocalPlayer localPlayer;
	private Player remotePlayer;

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
		localPlayer.getModelUpdater().update(move);
	}

}
