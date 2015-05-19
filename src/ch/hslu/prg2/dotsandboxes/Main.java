package ch.hslu.prg2.dotsandboxes;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
				MsgDiag dialog = new MsgDiag();
				try {
					SwingUtilities.invokeAndWait(dialog);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return dialog.isRequestAccepted();
			}

		};

		GameServer server = new GameServer(requestHandler);
		server.startListen();
	}

	static class MsgDiag implements Runnable {

		private boolean requestAccepted;

		public MsgDiag() {
			requestAccepted = false;
		}

		public boolean isRequestAccepted() {
			return requestAccepted;
		}

		@Override
		public void run() {
			int result = JOptionPane.showConfirmDialog(null,
					"New Request received from Player /n" + "with IP: "
							+ "unknown" + "./n"
							+ "Would you like to start the game?",
					"Request Received", JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				requestAccepted = true;
			} else {
				requestAccepted = false;
			}
		}
	}
}
