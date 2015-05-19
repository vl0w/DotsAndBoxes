package ch.hslu.prg2.dotsandboxes.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JPanel;

import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public class DotsBoard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5291492139606723465L;

	private static final int boarder = 20;
	private static final int distance = 100;
	private static final int radius = 5;

	private Board board;
	private int size;

	private boolean doDrawTheAwesomeFireWork;

	public DotsBoard(int size, Board board) {
		this.size = size;
		this.board = board;
		setBackground(Color.PINK);
		setLayout(null);
		drawLines();
		int widthHeight = size * distance + (size + 1) * radius + 2 * boarder;
		setSize(new Dimension(widthHeight, widthHeight));
		setVisible(true);
	}

	public void drawLines() {
		int x, y;
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= size; j++) {
				x = boarder + i * distance;
				y = boarder + j * distance;
				Dot d1a = new Dot(i, j);
				Dot d2a = new Dot(i + 1, j);
				Dot d1b = new Dot(i, j);
				Dot d2b = new Dot(i, j + 1);
				LineButton but1 = new LineButton(d1a, d2a, getBoard());
				LineButton but2 = new LineButton(d1b, d2b, getBoard());

				if (i < size) {
					if (getBoard().getGameBoard() != null) {
						but1.setBackground(playerColorToColor(getBoard()
								.getGameBoard().getLineColor(d1a, d2a)));
					} else {
						but1.setBackground(LineButton.DEFAULT_LINE_COLOR);
					}
					but1.setBounds(x + radius, y - radius / 2, distance - 2
							* radius, radius);
					but1.setVisible(true);
					add(but1);
				}
				if (j < size) {
					if (getBoard().getGameBoard() != null) {
						but2.setBackground(playerColorToColor(getBoard()
								.getGameBoard().getLineColor(d1b, d2b)));
					} else {
						but1.setBackground(LineButton.DEFAULT_LINE_COLOR);
					}
					but2.setBounds(x - radius / 2, y + radius, radius, distance
							- 2 * radius);
					but2.setVisible(true);
					add(but2);
				}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int xc, yc;
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= size; j++) {
				xc = boarder + i * distance;
				yc = boarder + j * distance;// +scoringBoard.getHeight();

				drawCircle(g, xc, yc, radius);
			}
		}
	}

	public static void drawCircle(Graphics g, int x, int y, int radius) {
		int diameter = radius * 2;
		g.setColor(Color.BLACK);
		// shift x and y by the radius of the circle in order to correctly
		// center it
		g.fillOval(x - radius, y - radius, diameter, diameter);
	}

	public Board getBoard() {
		return board;
	}

	public static Color playerColorToColor(PlayerColor pCol) {
		Color col;
		switch (pCol) {
		case BLUE: {
			col = Color.BLUE;
			break;
		}
		case RED: {
			col = Color.RED;
			break;
		}
		default: {
			col = LineButton.DEFAULT_LINE_COLOR;
		}
		}
		return col;
	}
}
