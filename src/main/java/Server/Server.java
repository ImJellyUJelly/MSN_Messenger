package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Server extends Thread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4567);
        Socket client = serverSocket.accept();

    }

}
