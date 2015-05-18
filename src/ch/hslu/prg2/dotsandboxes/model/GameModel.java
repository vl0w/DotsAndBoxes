package ch.hslu.prg2.dotsandboxes.model;


public interface GameModel {
	void handleMove(Move move);

	void addModelListener(GameModelListener listener);
}
