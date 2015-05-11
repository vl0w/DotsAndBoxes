package ch.hslu.prg2.dotsandboxes.game;

import ch.hslu.prg2.dotsandboxes.Player;

public class Game {

	private Player redPlayer;
	private Player bluePlayer;
	private GameBoardArray board;

	Game(Player redPlayer, Player bluePlayer, int size) {
		this.redPlayer = redPlayer;
		this.bluePlayer = bluePlayer;
	}
	
	public void startGame(int size){
		board=new GameBoardArray();
		board.createBoard(size);
	}
	
	public void save(){
		
	}
}
