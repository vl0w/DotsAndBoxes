package ch.hslu.prg2.dotsandboxes.game;

public interface GameBoard {
	PlayerColor getLineColor(Dot dot1, Dot dot2);	
	/**
	 * 
	 * @return the size of the game board. The board is always a square.
	 */
	int size();
}
