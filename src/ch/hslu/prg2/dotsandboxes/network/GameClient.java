package ch.hslu.prg2.dotsandboxes.network;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * A TCP game client.
 * @author Hyunkyo Suh
 */
public class GameClient {
    private static final int PORT_NUMBER = 7777;
    private static final String HOST_ADDRESS = "127.0.0.1"; // Default host address

    private Socket clientSocket;

    private BufferedReader inStream;
    private PrintWriter outStream;

    /**
     * Create a TCP game client with default host address.
     */
    public GameClient(){
        clientSocket = new Socket(HOST_ADDRESS, PORT_NUMBER);
    }

    /**
     * Create a TCP game client with specified host address.
     */
    public GameClient(String hostAddress) throws IOException {
        try (
            clientSocket = new Socket(hostAddress, PORT_NUMBER);
            inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outStream = new PrintWriter(clientSocket.getOutputStream());
        ) {
           //TODO Normalfall, Game Objekte werden gelesen und weitergeleitet
        } catch (UnknownHostException e) {
            System.out.println("Host " + hostAddress + "doesn't exist");
        } catch (IOException e) {
            System.out.println("Couldn't connect");
            System.exit(1);
        }

    }
}
