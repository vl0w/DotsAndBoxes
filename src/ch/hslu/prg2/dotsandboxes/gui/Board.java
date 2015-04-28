package gui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	public Board() {
		setLayout(new BorderLayout());
		
		add(initScoringBoard(),BorderLayout.NORTH);
	}

	private JPanel initScoringBoard(){
		JPanel scoringBoard = new JPanel(true);
		JLabel player1 = new JLabel("Player 1");
		JLabel player2 = new JLabel("Player 2");
		JLabel scores = new JLabel("0 : 0");

		scoringBoard.add(player1);
		scoringBoard.add(player2);
		scoringBoard.add(scores);
		
		return scoringBoard;
	}
	
}
