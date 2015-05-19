package ch.hslu.prg2.dotsandboxes.model;

/**
* Verarbeitet den Spielzug und informiert �ber erfolgreichem bzw. nicht erfolgreichem Zug.
*/


public interface GameModel {
	void handleMove(Move move);

	GameBoard getCurrentGameBoard();

	void addModelListener(GameModelListener listener);
}
