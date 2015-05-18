package ch.hslu.prg2.dotsandboxes.network;

import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 *
 * @author Hyunkyo Suh
 */
public class GameClient {
    private static final int PORT_NUMBER = 7777;
    private Socket clientSocket;

    public GameClient(String hostAddress) {
        try {
            clientSocket = new Socket(hostAddress, PORT_NUMBER);
        } catch (UnknownHostException uhe) {
            System.out.println("Host " + hostAddress + "doesn't exist");
        } catch (IOException ioe) {
            System.out.println("Couldn't connect");
            System.exit(1);
        }
    }
}
