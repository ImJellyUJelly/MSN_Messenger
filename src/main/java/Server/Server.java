package Server;

import java.net.ServerSocket;
import java.util.Scanner;
import java.io.*;

public class Server extends Thread {
    private ServerSocket serverSocket;
    private Scanner scanner;
    private int portNr;

    public Server() throws IOException {
        scanner = new Scanner(System.in);
        serverSocket = new ServerSocket(portNr);

    }
}
