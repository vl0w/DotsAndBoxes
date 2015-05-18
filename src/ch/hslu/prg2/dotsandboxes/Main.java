package ch.hslu.prg2.dotsandboxes;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import ch.hslu.prg2.dotsandboxes.network.GameServer;
import ch.hslu.prg2.dotsandboxes.network.IncomingRequestHandler;
import ch.hslu.prg2.dotsandboxes.view.SettingsDialog;

public class Main {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		startGameServer();
		SettingsDialog dialog = new SettingsDialog();
	}

	private static void startGameServer() throws IOException {
		IncomingRequestHandler requestHandler = new IncomingRequestHandler() {

			@Override
			public boolean acceptRequest() {
				int result = JOptionPane.showConfirmDialog(null,
						"New Request received from Player /n" + "with IP: "
								+ "unknown" + "./n"
								+ "Would you like to start the game?",
						"Request Received", JOptionPane.YES_NO_OPTION);
				System.out.println("Result: " + result);
				if (result == 0) {
					return true;
				} else {
					return false;
				}
			}
		};

		GameServer server = new GameServer(requestHandler);
		server.startListen();
	}
}
