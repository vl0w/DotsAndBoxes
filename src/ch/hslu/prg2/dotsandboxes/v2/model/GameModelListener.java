package ch.hslu.prg2.dotsandboxes.v2.model;

import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;

public interface GameModelListener {
	void moveDone(GameBoard gameBoard, Move move);

	void moveFailed(Move move);
}
