package ch.hslu.prg2.dotsandboxes.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javafx.stage.FileChooser;

import javax.swing.JFrame;

import ch.hslu.prg2.dotsandboxes.model.GameModelPersister;

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
		setMenuBar(initMenuBar());
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
	
	private MenuBar initMenuBar(){
		MenuBar menuBar = new MenuBar();
		Menu game = new Menu("Game");
		game.addActionListener(new MenuListener());
		MenuItem saveGame = new MenuItem("Save Game");
		saveGame.addActionListener(new MenuListener());
		game.add(saveGame);
		menuBar.add(game);
		return menuBar;
	}
	
	private class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuItem actItem = (MenuItem) e.getSource();
			switch (actItem.getLabel()){
			case "Save Game":{ 
				FileChooser chooser = new FileChooser();	
				File file = chooser.showSaveDialog(null);
				if (file != null){
					GameModelPersister.save(file);
				}	
				break;
			}default:{		
			}
			}
		}
		
	}

}
