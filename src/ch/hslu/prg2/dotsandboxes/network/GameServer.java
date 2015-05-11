package ch.hslu.prg2.dotsandboxes.network;

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

    /**
     * Create a TCP game server.
     */
    public GameServer() {
        serverSocket = new ServerSocket(PORT_NUMBER);
    }
}
