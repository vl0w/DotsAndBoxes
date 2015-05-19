package ch.hslu.prg2.dotsandboxes.model;

/**
* Dient zum Verwalten der Linien, Squares und dessen aktuellen Zustand.
* Über das Interface können die Grösse  des Spielfeldes und der aktuelle Punktestand abgefragt weren.
*/


public interface GameBoard {
	PlayerColor getLineColor(Dot dot1, Dot dot2);	
	/**
	 * 
	 * @return the size of the game board. The board is always a square.
	 */
	int size();
	
	int getPlayerScores(PlayerColor color);
}
