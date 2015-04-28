package ch.hslu.prg2.dotsandboxes;

import ch.hslu.prg2.dotsandboxes.game.GameBoard;

public interface Player {
	Move makeMove(GameBoard board);

	void notifyMoved(GameBoard board);

	void notifyMoveFailed(GameBoard board);
}
