package edu.upc.eetac.dsa.exercici7.java.lang;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
/**
 * Created by User on 26/09/2015.
 */
public class DaytimeTCPServer {
    private final static int DEFAULT_PORT = 12345;

    public static void main(String[] args) throws IOException {
        int port = (args.length == 1) ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //Establece formato de fecha
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(sdf.format(System.currentTimeMillis()));
            writer.flush();
        }
    }
}