package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import ch.hslu.prg2.dotsandboxes.game.Game;

public class Application extends JFrame {
	private Board board;
	private int size =2;

	private static final long serialVersionUID = 1L;

	public Application() throws HeadlessException {
		initUI();
	}
	
	private void initUI(){
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(1000,1000);
        setLocationRelativeTo(null);
		SettingsDialog settings = new SettingsDialog();

		if (settings.isReadyToStart()){
		
			board = new Board(settings.getSize());
			getContentPane().add(board);
			setSize(board.getWidth(),board.getHeight());
			//setResizable(false);
			//pack();
			centreWindow(this);
			setVisible(true);
			
	        if(true){		
	        	Enumeration<AbstractButton> buts = settings.getGameType();
	        	while (buts.hasMoreElements()){
	        		JRadioButton but = (JRadioButton) buts.nextElement();
	        		if (but.isSelected()){
	        			but.getText();
	        			System.out.println("Spieltyp: "+but.getText());
	        		}
	        	}
	        	Game game = new Game(getBoard().getActualPlayer(), getBoard().getPlayer2());
	        	game.startGame(size);
	        }
		}else{
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
        
	}
	public Board getBoard(){
		return board;
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

}
