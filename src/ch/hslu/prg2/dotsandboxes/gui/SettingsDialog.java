package ch.hslu.prg2.dotsandboxes.gui;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SettingsDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 8661521510719951347L;

	JPanel enemy;
	JPanel fieldSize;

	private static final String[] PLAYERTYPES = {"Mensch","Netzwerk","KI"};
	
	public SettingsDialog() {
		JOptionPane pane = new JOptionPane();
		JDialog dialog = pane.createDialog("Settings");
		//dialog.setTitle("Settings");
		dialog.setSize(300, 200);
		
		enemy = new JPanel(true);
		for(String st: PLAYERTYPES){
		   enemy.add(new JRadioButton(st));
		}
		dialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
