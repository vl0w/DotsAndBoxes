package ch.hslu.prg2.dotsandboxes.model;

public interface GameModelListener {
	void moveDone(GameBoard gameBoard, MoveResult result);

	void moveFailed(Move move);
}
