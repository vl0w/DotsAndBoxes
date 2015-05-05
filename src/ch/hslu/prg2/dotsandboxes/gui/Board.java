package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel {//implements Player {
	JPanel scoringBoard;
	JLabel player1;
	JLabel player2;
	JLabel scores;
	int boarder = 20;
	int distance = 40;
	
	int size;
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	public Board(int size) {
		this.size = size;
		setLayout(new BorderLayout());
		
		add(initScoringBoard(),BorderLayout.NORTH);
		add(initGameBoard(size),BorderLayout.SOUTH);
	}

	private JPanel initScoringBoard(){
		scoringBoard = new JPanel(true);
		player1 = new JLabel("Player 1");
		player2 = new JLabel("Player 2");
		scores = new JLabel("0 : 0");

		scoringBoard.add(player1);
		scoringBoard.add(scores);
		scoringBoard.add(player2);
		
		return scoringBoard;
	}
	private JPanel initGameBoard(int size){
		JPanel gameBoard = new JPanel();
		gameBoard.setSize(size*20,size*20);
		
		return gameBoard;
		
	}
	
	@Override
	public void paint(Graphics g){
		for (int i=0; i<=size;i++){
			for(int j = 0; j<=size;j++){
				drawCircle(g,boarder+i*40,boarder+j*40,5);
			}
		}
		scores.setText("0 : 0");
	}
	
	public static void drawCircle(Graphics g, int x, int y, int radius) {

		  int diameter = radius * 2;

		  //shift x and y by the radius of the circle in order to correctly center it
		  g.fillOval(x - radius, y - radius, diameter, diameter); 
		}
}
