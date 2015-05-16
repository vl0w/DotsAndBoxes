package ch.hslu.prg2.dotsandboxes.gui;

import ch.hslu.prg2.dotsandboxes.game.Dot;
import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;
import ch.hslu.prg2.dotsandboxes.v2.Player;

public class GUIPlayer implements Player {
	
	private boolean moved = false;
	private Move actualMove;
	private boolean isLocalPlayer;
	private Board board;

	public GUIPlayer(boolean isLocalPlayer, Board board) {
		this.isLocalPlayer = isLocalPlayer;
		this.board = board;
	}

	@Override
	public Move makeMove(GameBoard board) {
		getBoard().setGameBoard(board);
		getBoard().getDotsBoard().drawLines();
		Thread t = new Thread(){

			@Override
			public void run() {
				while(!moved){
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Whuup_Thread_Verlassen");
				
				moved=false;
			}
			
		};t.start();
		System.out.println("Whuup_Thread_kurz vor Ende");
		return actualMove;

	}

	@Override
	public void notifyMoved(GameBoard board) {
		getBoard().setGameBoard(board);
		getBoard().setActualPlayer((getBoard().getPlayer1()==this)?getBoard().getPlayer2():getBoard().getPlayer1());
	}

	@Override
	public void notifyMoveFailed(GameBoard board) {
		makeMove(board);

	}

	@Override
	public void notifyGameEnd(GameBoard board) {
		// TODO Auto-generated method stub

	}

	public void linePressed(Dot d1, Dot d2){;
		actualMove = new Move(d1,d2);
		moved = true;		
	}
	
	public boolean isLocalPlayer() {
		return isLocalPlayer;
	}

	public void setLocalPlayer(boolean isLocalPlayer) {
		this.isLocalPlayer = isLocalPlayer;
	}

	@Override
	public String toString(){
		return (isLocalPlayer())? "Local Player": "Second Player";
	}

	public Board getBoard() {
		return board;
	}
}
