package ch.hslu.prg2.dotsandboxes.game;

import ch.hslu.prg2.dotsandboxes.Player;

public class Game {

	private Player redPlayer;
	private Player bluePlayer;

	Game(Player redPlayer, Player bluePlayer, int size) {
		this.redPlayer = redPlayer;
		this.bluePlayer = bluePlayer;
		
	}
	
	public void startGame(int size, Player playrRed, Player playerBlue){
		GameBoardArray.createBoard(size);
	}
	
	public void save(){
		
	}
}
