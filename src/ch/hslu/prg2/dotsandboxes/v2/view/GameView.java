package ch.hslu.prg2.dotsandboxes.v2.view;

import ch.hslu.prg2.dotsandboxes.game.GameBoard;

public interface GameView {
	void update(GameBoard gameBoard);

	void addViewListener(GameViewListener listener);
}
