package ch.hslu.prg2.dotsandboxes.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private Board board;
	private int size;

	private static final long serialVersionUID = 1L;

	public MainWindow(int size) throws HeadlessException {
		this.size = size;
		initUI();
	}

	private void initUI() {
		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setSize(1000,1000);
		setLocationRelativeTo(null);

		board = new Board(this.size);
		getContentPane().add(board);
		setSize(board.getWidth(), board.getHeight());
		centreWindow(this);
		setVisible(true);
	}

	public Board getBoard() {
		return board;
	}

	public static void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

}
