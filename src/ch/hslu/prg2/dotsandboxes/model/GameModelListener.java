package ch.hslu.prg2.dotsandboxes.model;


public interface GameModelListener {
	void moveDone(GameBoard gameBoard, Move move);

	void moveFailed(Move move);
}
