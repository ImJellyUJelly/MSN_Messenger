package Server;

import jdk.internal.util.xml.impl.Input;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;

        try {
            serverSocket = new ServerSocket(4567);
            System.out.println("Waiting for clients to connect...");



            while (true) {
                socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                byte[] buffer = new byte[512];
                String line;
                while (true) {
                    in.read(buffer);
                    System.out.println("From client: " + new String(buffer));
                    break;
                }

                OutputStream out = socket.getOutputStream();
                out.write("Hello mr client".getBytes());
            }
        } catch (IOException iox) {
            System.out.println("Can't assign to this port.");
            iox.printStackTrace();
        }
    }

    public Server() {
    }
}
