package ch.hslu.prg2.dotsandboxes.game;

import ch.hslu.prg2.dotsandboxes.Player;

public class Game {

	private Player redPlayer;
	private Player bluePlayer;
	private GameBoardArray gameboard;
	private Move actualMove; 

	public Game(Player redPlayer, Player bluePlayer) {
		this.redPlayer = redPlayer;
		this.bluePlayer = bluePlayer;
	}
	
	public void startGame(int size){
		gameboard=new GameBoardArray();
		gameboard.createBoard(size);
		gameboard.createSquares();
		gameLogic();
	}
	
	public void gameLogic(){
		RedPlayerMove();
		BluePlayerMove();
	}
	
	public boolean RedPlayerMove(){
		boolean ret=false;
		actualMove=redPlayer.makeMove(gameboard);
		while(ret==false){
			if(treatMove(actualMove)){
				redPlayer.notifyMoved(gameboard);
				bluePlayer.notifyMoved(gameboard);
				return ret=true;
			}
			else{
				redPlayer.notifyMoveFailed(gameboard);
				actualMove=redPlayer.makeMove(gameboard);
			}
		}
		return ret;
	}
	
	public boolean BluePlayerMove(){
		boolean ret=false;
		actualMove=bluePlayer.makeMove(gameboard);
		while(ret==false){
			if(treatMove(actualMove)){
				bluePlayer.notifyMoved(gameboard);
				redPlayer.notifyMoved(gameboard);
				return ret=true;
			}
			else{
				bluePlayer.notifyMoveFailed(gameboard);
				actualMove=bluePlayer.makeMove(gameboard);
			}
		}
		return ret;
	}
	
	public boolean treatMove(Move move){
		boolean ret=false;
		if(gameboard.setLine(move.getDot1(), move.getDot2(), move.getPlayerColor())){
			ret=true;
		}
		return ret;
	}
	
	public void save(){
		
	}
}
