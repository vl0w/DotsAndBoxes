package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.game.Game;
import ch.hslu.prg2.dotsandboxes.game.GameFactory;

public class Application extends JFrame {


	private static final long serialVersionUID = 1L;

	public Application() throws HeadlessException {
		initUI();
	}
	
	private void initUI(){
		add(new Board(2));		
	    setSize(300, 300);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        new SettingsDialog();
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
