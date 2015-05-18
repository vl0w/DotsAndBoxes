package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CustomDialog extends JFrame {
	private JRadioButton radButLocal;
	private JRadioButton radButAI;
	private JRadioButton radButNetwork;
	private JTextField   textFieldIP;

	private static final String[] PLAYERTYPES = {"Mensch","Netzwerk","KI"};

	public CustomDialog() throws HeadlessException {
		setSize(500,300);
		
		//getContentPane().add(initPlayerSettings());		
	}
	

	
	

}
