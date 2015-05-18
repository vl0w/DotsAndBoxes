package ch.hslu.prg2.dotsandboxes.view;

import ch.hslu.prg2.dotsandboxes.model.GameBoard;

public interface GameView {
	void update(GameBoard gameBoard);

	void addViewListener(GameViewListener listener);
}
