package ch.hslu.prg2.dotsandboxes.v2;

import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public interface Player {
	void gameEnded();

	void yourTurn();

	void opponentTurn();

	PlayerColor getColor();
}
