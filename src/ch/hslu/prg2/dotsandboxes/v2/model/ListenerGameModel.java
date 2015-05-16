package ch.hslu.prg2.dotsandboxes.v2.model;

import java.util.List;

import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;

public class ListenerGameModel implements GameModel {

	private List<GameModelListener> listeners;

	@Override
	public void handleMove(Move move) {
		// TODO implement

		// if ok
		notifyListenersMoveDone(null, move);

		// if nok
		notifyListenersMoveFailed(move);
	}

	public void addModelListener(GameModelListener listener) {
		this.listeners.add(listener);
	}

	private void notifyListenersMoveDone(GameBoard gameBoard, Move move) {
		for (GameModelListener listener : this.listeners) {
			listener.moveDone(gameBoard, move);
		}
	}

	private void notifyListenersMoveFailed(Move move) {
		for (GameModelListener listener : this.listeners) {
			listener.moveFailed(move);
		}
	}
}
