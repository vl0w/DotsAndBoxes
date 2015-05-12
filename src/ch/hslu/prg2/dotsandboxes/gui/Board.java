package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hslu.prg2.dotsandboxes.game.GameBoard;


public class Board extends JPanel {// implements Player {
	private JPanel scoringBoard;
	private JLabel labPlayer1;
	private JLabel labPlayer2;
	private JLabel labScores;

	private DotsBoard dotsBoard;
	private GameBoard gameBoard;
	private GUIPlayer player1;
	private GUIPlayer player2;
	private GUIPlayer actualPlayer;

	int boarder = 20;
	int distance = 70;
	int radius = 5;
	
	int size;
	private static final long serialVersionUID = 10L;

	public Board(int size) {
		super(new BorderLayout(),true);
		this.size = size;
		setPreferredSize(new Dimension(500,500));
		
		add(initScoringBoard(),BorderLayout.NORTH);

		dotsBoard = new DotsBoard(size,this);
		add(dotsBoard,BorderLayout.CENTER);	
		
		setVisible(true);
		
		setPlayer1(new GUIPlayer(true,this));
		setPlayer2(new GUIPlayer(false,this));
		setActualPlayer(getPlayer1());

	}

	private JPanel initScoringBoard(){
		scoringBoard = new JPanel(true);
		labPlayer1 = new JLabel("Player 1");
		labPlayer2 = new JLabel("Player 2");
		labScores = new JLabel("0 : 0");
		
		labPlayer1.setBackground(Color.BLUE);
		labPlayer2.setBackground(Color.RED);
		labPlayer1.setVisible(true);
		labPlayer2.setVisible(true);
		labScores.setVisible(true);
		scoringBoard.add(labPlayer1);
		scoringBoard.add(labScores);
		scoringBoard.add(labPlayer2);
		scoringBoard.setVisible(true);
		return scoringBoard;
	}

	public int getBoarder() {
		return boarder;
	}

	public int getDistance() {
		return distance;
	}

	public int getRadius() {
		return radius;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public GUIPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(GUIPlayer player2) {
		this.player2 = player2;
	}

	public GUIPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(GUIPlayer player1) {
		this.player1 = player1;
	}

	public void setActualPlayer(GUIPlayer player){
		this.actualPlayer = player1;
	}
	
	public GUIPlayer getActualPlayer(){
		return this.actualPlayer;
	}

	public DotsBoard getDotsBoard() {
		return this.dotsBoard;
	}

}
