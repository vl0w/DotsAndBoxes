package ch.hslu.prg2.dotsandboxes.network;

import java.io.ObjectInputStream;
import java.net.Socket;

public class IncomingObjectListener implements Runnable {
    private Socket clientSocket;
    private NetworkListenerDelegate delegate;

    public IncomingObjectListener(Socket clientSocket, NetworkListenerDelegate delegate) {
        this.clientSocket = clientSocket;
        this.delegate = delegate;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inStream = new ObjectInputStream(clientSocket.getInputStream());
            Object obj = inStream.readObject();
            delegate.received(obj);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }

    }
}
