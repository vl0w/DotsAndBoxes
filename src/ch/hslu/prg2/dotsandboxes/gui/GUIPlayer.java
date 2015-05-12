package ch.hslu.prg2.dotsandboxes.gui;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.game.Dot;
import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;

public class GUIPlayer implements Player {
	
	private boolean moved = false;
	private Move actualMove;
	public boolean isLocalPlayer() {
		return isLocalPlayer;
	}

	public void setLocalPlayer(boolean isLocalPlayer) {
		this.isLocalPlayer = isLocalPlayer;
	}

	private boolean isLocalPlayer;
	public GUIPlayer(boolean isLocalPlayer) {
		this.isLocalPlayer = isLocalPlayer;
	}

	@Override
	public Move makeMove(GameBoard board) {
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
				
				moved=false;
			}
			
		};t.start();
		
		return actualMove;
	}

	@Override
	public void notifyMoved(GameBoard board) {
		Board.setGameBoard(board);
		Board.setActualPlayer((Board.getPlayer1()==this)?Board.getPlayer2():Board.getPlayer1());
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

}
