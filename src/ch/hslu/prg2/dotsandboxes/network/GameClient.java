package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.model.GameModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Hyunkyo Suh
 */
public class GameClient {
    private static final int PORT_NUMBER = 7777;
    private Socket clientSocket;
    private String hostAdress;
    private GameModel gameModel;

    /**
     *
     * @param hostAddress IP address of the opponent
     * @param gameModel
     */
    public GameClient(String hostAddress, GameModel gameModel) {
        this.hostAdress = hostAddress;
        this.gameModel = gameModel;
    }

    /**
     * Try to make contact with the opponent
     * @return
     * @throws IOException
     */
    public LocalNetworkGate connect() throws IOException {
            clientSocket = new Socket(hostAdress, PORT_NUMBER);
            ObjectInputStream inStream = new ObjectInputStream(clientSocket.getInputStream());
            boolean serverResponse = inStream.readBoolean();
            if(serverResponse) {
                new Thread(new IncomingObjectListener(clientSocket, new LocalNetworkListenerDelegate(gameModel))).start();
                return new LocalNetworkGate();
            } else {
                throw new IOException("Host rejected connection");
            }
    }
}
