package ch.hslu.prg2.dotsandboxes.v2;

import ch.hslu.prg2.dotsandboxes.game.PlayerColor;

public interface Player {
	void gameStarted();

	void gameEnded();

	void yourTurn();

	void oponnentTurn();

	PlayerColor getColor();
}
