package ch.hslu.prg2.dotsandboxes;

import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public interface Player {
	void gameEnded();

	void yourTurn(GameBoard gameBoard);

	void opponentTurn();

	PlayerColor getPlayerColor();
}
