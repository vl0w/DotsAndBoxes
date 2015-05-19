package ch.hslu.prg2.dotsandboxes.model;

/**
* Interessierte Klassen welche Events des Gamemodels empfangen wollen k�nnen sich als GameModelListener beim GameModel registrieren.
*/

public interface GameModelListener {
	void moveDone(GameBoard gameBoard, MoveResult result);

	void moveFailed(Move move);
}
