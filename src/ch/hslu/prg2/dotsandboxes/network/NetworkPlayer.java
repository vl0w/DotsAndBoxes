package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;

import java.io.IOException;
import java.net.Socket;

public class NetworkPlayer implements Player, Runnable {
	private Socket clientSocket;

	public NetworkPlayer(Socket client) {
		clientSocket = client;
	}

	@Override
	public void run() {
		// Ab jetzt werden Spielzuege hin- und hergeschickt
		try {

		} catch (IOException ioe) {
			System.out.println("Error: " + ioe.getMessage());
		}
	}

	@Override
	public Move makeMove(GameBoard board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notifyMoved(GameBoard board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyMoveFailed(GameBoard board) {
		// TODO Auto-generated method stub

	}

}
