package ch.hslu.prg2.dotsandboxes.model;

public interface GameModel {
	void handleMove(Move move);

	GameBoard getCurrentGameBoard();

	void addModelListener(GameModelListener listener);
}
