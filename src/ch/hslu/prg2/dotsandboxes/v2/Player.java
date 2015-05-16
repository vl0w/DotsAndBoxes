package ch.hslu.prg2.dotsandboxes;

import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;

public interface Player {
	Move makeMove(GameBoard board);

	void notifyMoved(GameBoard board);

	void notifyMoveFailed(GameBoard board);
	
	void notifyGameEnd(GameBoard board);
}
