package ch.hslu.prg2.dotsandboxes.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A TCP game server that runs on port 7777.
 * 
 * @author Hyunkyo Suh
 */
public class GameServer {
	private static final int PORT_NUMBER = 7777;
	private ServerSocket serverSocket;
	private IncomingRequestHandler requestHandler;

	public GameServer(IncomingRequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

	public void startListen() throws IOException {
		serverSocket = new ServerSocket(PORT_NUMBER);
		IncomingConnectionListener icl = new IncomingConnectionListener();
		new Thread(icl).start();
	}

	private class IncomingConnectionListener implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Warten auf Verbindung ...");
					Socket client = serverSocket.accept();
					System.out.println("Verbunden mit "
							+ client.getInetAddress());
					if (requestHandler.acceptRequest()) {
						new Thread(new IncomingObjectListener(client,
								new RemoteNetworkListenerDelegate())).start();
						writeAnswer(client, true);
					} else {
						writeAnswer(client, false);
					}
				} catch (Exception ioe) {
					System.err.println("Error: " + ioe.getMessage());
				}
			}
		}

		private void writeAnswer(Socket socket, boolean answer)
				throws IOException {
			ObjectOutputStream outStream = new ObjectOutputStream(
					socket.getOutputStream());
			outStream.writeBoolean(answer);
		}
	}
}
