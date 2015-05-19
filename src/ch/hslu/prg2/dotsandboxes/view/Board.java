package ch.hslu.prg2.dotsandboxes.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public class Board extends JPanel implements GameView, Player {
	private JPanel scoringBoard;
	private JLabel labPlayer1;
	private JLabel labPlayer2;
	private JLabel labScores;

	private DotsBoard dotsBoard;
	private GameBoard gameBoard;

	private List<GameViewListener> listeners;

	private int size;
	private static final long serialVersionUID = 10L;

	public Board(int size) {
		super(new BorderLayout(), true);
		this.size = size;
		listeners = new ArrayList<>();
		dotsBoard = new DotsBoard(size, this);
		add(initScoringBoard(), BorderLayout.NORTH);
		add(dotsBoard, BorderLayout.CENTER);
		setSize(new Dimension(dotsBoard.getWidth(), dotsBoard.getWidth()
				+ scoringBoard.getHeight() + 35));

		setVisible(true);
	}
	

	private JPanel initScoringBoard() {
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
		scoringBoard.setSize(dotsBoard.getWidth(), 30);
		scoringBoard.setVisible(true);
		return scoringBoard;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public DotsBoard getDotsBoard() {
		return this.dotsBoard;
	}

	@Override
	public void addViewListener(GameViewListener listener) {
		listeners.add(listener);
	}

	public void removeViewListener(GameViewListener listener) {
		listeners.remove(listener);
	}

	protected void linePressed(Dot d1, Dot d2) {
		for (GameViewListener listener : listeners) {
			listener.onLineSelected(d1, d2);
		}
	}

	@Override
	public void update(GameBoard board) {
		setGameBoard(board);
		dotsBoard.removeAll();
		dotsBoard.drawLines();
		dotsBoard.repaint();
		// TODO: Update scores
	}
	
	@Override
	public void paintComponent(Graphics g) {
		labScores.setText(gameBoard.getPlayerScores(getPlayerColor())+" : "
				+ gameBoard.getPlayerScores(PlayerColor.RED));
	};

	@Override
	public void gameEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerColor getPlayerColor() {
		return PlayerColor.BLUE; // TODO
	}

	public PlayerColor getOpponentColor() {
		return PlayerColor.RED; // TODO
	}



	@Override
	public void opponentTurn() {
		scoringBoard.setBackground(DotsBoard.playerColorToColor(getOpponentColor()));
	}

	@Override
	public void yourTurn(GameBoard gameBoard) {
		setGameBoard(gameBoard);
		scoringBoard.setBackground(DotsBoard.playerColorToColor(getPlayerColor()));
	}
}
