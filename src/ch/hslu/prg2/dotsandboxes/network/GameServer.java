package ch.hslu.prg2.dotsandboxes.network;

import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * A TCP game server that runs on port 7777.
 * @author Hyunkyo Suh
 */
public class GameServer {
    private static final int PORT_NUMBER = 7777;

    private ServerSocket serverSocket;
    private Socket clientSocket;

    private BufferedReader inStream;
    private PrintWriter outStream;

    /**
     * Create a TCP game server.
     */
    public GameServer() throws IOException {
        try(
            serverSocket = new ServerSocket(PORT_NUMBER);
            clientSocket = serverSocket.accept();
            inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outStream = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            //TODO Normfall, Game Objekte werden gelesen und weitergeleitet
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen to port " + PORT_NUMBER
                    + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
