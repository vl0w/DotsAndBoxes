package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public class LineButton extends JButton {

	private static final long serialVersionUID = 8608522602233328374L;
	private final static Color HOVER_BACKGROUND_COLOR = Color.GRAY;
	private final static Color PRESSED_BACKGROUND_COLOR = Color.RED;
	public final static Color DEFAULT_LINE_COLOR = Color.GREEN;

	private Dot d1;
	private Dot d2;
	private Board board;

	public LineButton(Dot d1, Dot d2, Board board) {
		super();

		this.d1 = d1;
		this.d2 = d2;
		this.board = board;

		setBorderPainted(false);
		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setBackground(Color.GREEN);

		addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (getBoard().getGameBoard() != null
						&& (getBoard().getGameBoard().getLineColor(getD1(),
								getD2()) == PlayerColor.NONE)) {
					if (getModel().isRollover()) {
						setBackground(HOVER_BACKGROUND_COLOR);

						setCursor(Cursor
								.getPredefinedCursor(Cursor.HAND_CURSOR));
					} else if (getModel().isPressed()) {
						setCursor(Cursor
								.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						setBackground(PRESSED_BACKGROUND_COLOR);
					} else {
						setBackground(DEFAULT_LINE_COLOR);
						setCursor(Cursor
								.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

					}
				}
			}
		});
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setBackground(Color.RED);
				// getBoard().getActualPlayer().linePressed(getD1(),getD2());
				getBoard().linePressed(getD1(), getD2());
				// System.out.println("LinePressed from "
				// + getBoard().getActualPlayer().toString() + " "
				// + getD1().toString() + " " + getD2().toString());
			}
		});

	}

	/*
	 * @Override protected void paintComponent(Graphics g) { if
	 * (getModel().isPressed()) { g.setColor(pressedBackgroundColor); } else if
	 * (getModel().isRollover()) { g.setColor(hoverBackgroundColor); } else {
	 * g.setColor(getBackground()); }
	 * 
	 * g.fillRect(0, 0, getWidth(), getHeight()); super.paintComponent(g); }
	 */
	public Dot getD1() {
		return d1;
	}

	public void setD1(Dot d1) {
		this.d1 = d1;
	}

	public Dot getD2() {
		return d2;
	}

	public void setD2(Dot d2) {
		this.d2 = d2;
	}

	public Board getBoard() {
		return board;
	}

}
