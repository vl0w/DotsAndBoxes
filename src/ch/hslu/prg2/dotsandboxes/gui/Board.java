package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hslu.prg2.dotsandboxes.game.GameBoard;


public class Board extends JPanel {// implements Player {
	private JPanel scoringBoard;
	private JLabel player1;
	private JLabel player2;
	private JLabel scores;
//	private JPanel gameBoard;
	private static GameBoard gameBoard;

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
		add(new DotsBoard(size),BorderLayout.CENTER);	
		setVisible(true);
	}

	private JPanel initScoringBoard(){
		scoringBoard = new JPanel(true);
		player1 = new JLabel("Player 1");
		player2 = new JLabel("Player 2");
		scores = new JLabel("0 : 0");
		
		player1.setBackground(Color.BLUE);
		player2.setBackground(Color.RED);
		player1.setVisible(true);
		player2.setVisible(true);
		scores.setVisible(true);
		scoringBoard.add(player1);
		scoringBoard.add(scores);
		scoringBoard.add(player2);
		scoringBoard.setVisible(true);
		return scoringBoard;
	}
/*
	private JPanel initGameBoard(int size){
//		gameBoard = new GameBoard(size);
//		gameBoard.setSize(size*20,size*20);
//		gameBoard.setVisible(true);
		gameBoard = new JPanel(true);
		gameBoard.setBackground(Color.CYAN);
		gameBoard.setLayout(null);
		//gameBoard.setBounds(0, 30, 500,500);
		//gameBoard.setSize(500,500);
		//gameBoard.setLocation(0,scoringBoard.getHeight());
		drawLines();
		gameBoard.setVisible(true);
		return gameBoard;
		
	}
	
	private void drawLines(){
		int xc,yc,xl,yl;
		for (int i=0; i<=size;i++){
			for(int j = 0; j<=size;j++){
				xc = boarder+i*distance;
				yc = boarder+j*distance+scoringBoard.getHeight();
				xl = xc-radius/2;
				yl = yc-radius/2;
				JButton but1 = new JButton();
				JButton but2 = new JButton();

				but1.addMouseListener(new MyMouseListener());
				but2.addMouseListener(new MyMouseListener());

				if (i<size){
					but1.setBounds(xl,yl,distance,radius);
					but1.setVisible(true);
					gameBoard.add(but1);
				}
				if (j<size){
					but2.setBounds(xl,yl,radius,distance);
//					drawLines(g,xl,yl,radius,distance,Color.BLUE);
					but2.setVisible(true);
					gameBoard.add(but2);
				}
			}
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		drawDotsAndLines(g);
		scores.setText("1 : 0");
		
		int xc,yc,xl,yl;
		for (int i=0; i<=size;i++){
			for(int j = 0; j<=size;j++){
				xc = boarder+i*distance;
				yc = boarder+j*distance+scoringBoard.getHeight();
				xl = xc-radius/2;
				yl = yc-radius/2;
				if (i<size){
//					drawLines(g,xl,yl,distance,radius,Color.RED);
				}
				if (j<size){
//					drawLines(g,xl,yl,radius,distance,Color.BLUE);
				}
				drawCircle(g,xc,yc,radius);
			}
		}

	}
	
	public static void drawCircle(Graphics g, int x, int y, int radius) {
		  int diameter = radius * 2;
		  g.setColor(Color.BLACK);
		  //shift x and y by the radius of the circle in order to correctly center it
		  g.fillOval(x - radius, y - radius, diameter, diameter); 
	}
	
	public static void drawLines(Graphics g,int x,int y,int radius,int distance,Color color){
			Rectangle2D rect = new Rectangle2D.Double(x,y,radius,distance);
			lines.add(rect);
			//g.fillRect(x,y,radius,distance);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(color);
			g2d.fill(rect);
			
	}
	
	class MyMouseListener extends MouseAdapter{
		public void MouseMoved(MouseEvent e){
			for (Rectangle2D r: lines){
				if (r.contains(e.getX(),e.getY())){
					System.out.println("MouseMove Rectangle x: "+e.getX()+" y: "+e.getY());
				}
			}
		}
		public void MouseEntered(MouseEvent e){
			((JButton) e.getSource()).setBackground(Color.GRAY);
		}
		public void mouseExcited(MouseEvent e){
			((JButton) e.getSource()).setBackground(Color.YELLOW);
		}
	}
*/	
	public int getBoarder() {
		return boarder;
	}

	public int getDistance() {
		return distance;
	}

	public int getRadius() {
		return radius;
	}
/*
	public static void main(String[] args){
	    // construct the GUI on the EDT
	    SwingUtilities.invokeLater( new Runnable() {
	        public void run() {
	            JFrame frame = new JFrame("User Details");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	            frame.getContentPane().add(new Board(3));
	            // important!
	            frame.pack();
	
	            frame.setVisible(true);
	        }
	    });
	}
*/

	public static GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		Board.gameBoard = gameBoard;
	}

}
