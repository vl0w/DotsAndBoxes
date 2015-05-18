package ch.hslu.prg2.dotsandboxes.network;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

/**
 * A TCP game server that runs on port 7777.
 * @author Hyunkyo Suh
 */
public class GameServer {
    private static final int PORT_NUMBER = 7777;
    private ServerSocket serverSocket;

    /**
     * Create a TCP game server.
     */
    public GameServer() {
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        }
    }

    private void listen() {
        while (true) {
            try {
                System.out.println("Warten auf Verbindung ...");
                Socket client = serverSocket.accept();
                System.out.println("Verbunden mit " + client.getInetAddress());
                NetworkPlayer nwp = new NetworkPlayer(client);
                new Thread(nwp).start();
            } catch (IOException ioe) {
                System.err.println("Error: " + ioe.getMessage());
            }
        }
    }
}
