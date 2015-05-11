package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hslu.prg2.dotsandboxes.game.Dot;
import ch.hslu.prg2.dotsandboxes.game.PlayerColor;

public class LineButton extends JButton {

	private Color hoverBackgroundColor = Color.blue;
	private Color pressedBackgroundColor = Color.RED;

	private Dot d1;
	private Dot d2;

	public LineButton(Dot d1, Dot d2) {
		super();

		this.d1 = d1;
		this.d2 = d2;
		System.out.println("LineButton created Dot1: " + d1.toString()
				+ " Dot2: " + d2.toString());
		setBorderPainted(false);
		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setBackground(Color.GREEN);

		addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (true ||Board.getGameBoard().getLineColor(getD1(), getD2()) != PlayerColor.NONE) {
					if (getModel().isRollover()) {
						setBackground(hoverBackgroundColor);

						setCursor(Cursor
								.getPredefinedCursor(Cursor.HAND_CURSOR));
					} else if (getModel().isPressed()) {
						setCursor(Cursor
								.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						setBackground(pressedBackgroundColor);
					} else {
						setBackground(Color.GREEN);
						setCursor(Cursor
								.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

					}
				}
			}
		});
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.RED);

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
}
