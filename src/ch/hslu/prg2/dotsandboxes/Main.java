package ch.hslu.prg2.dotsandboxes;

import javax.swing.JOptionPane;

import ch.hslu.prg2.dotsandboxes.gui.SettingsDialog;

public class Main {
	private static String ip = "127.168.1.1";

	public static void main(String[] args) {
		SettingsDialog dialog = new SettingsDialog();
		int result = JOptionPane.showConfirmDialog(null,
				"New Request received from Player /n"+
				"with IP: "+ip+"./n"+
				"Would you like to start the game?",
				"Request Received",
			    JOptionPane.YES_NO_OPTION);
		System.out.println("Result: "+result);
		if (result==0){
			//TODO Accept Request
		}else{
			//TODO Didn't accept request
		}
	}
}
