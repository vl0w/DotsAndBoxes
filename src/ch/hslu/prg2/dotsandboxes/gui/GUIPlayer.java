package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;

public class GUIPlayer implements Player, ActionListener {
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		LineButton line= (LineButton) e.getSource();
		actualMove = new Move(line.getD1(),line.getD2());
		moved = true;		
	}

}
