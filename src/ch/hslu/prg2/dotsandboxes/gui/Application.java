package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import ch.hslu.prg2.dotsandboxes.Player;
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
        setLocationRelativeTo(null);
		getContentPane().add(new Board(size));
if(true){		
		Game game = new Game(Board.getActualPlayer(), Board.getPlayer2());
		game.startGame(size);
}		
        pack();
        
        setVisible(true);
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

}
