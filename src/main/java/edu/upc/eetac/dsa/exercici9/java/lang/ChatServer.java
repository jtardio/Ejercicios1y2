package edu.upc.eetac.dsa.exercici9.java.lang;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by User on 27/09/2015.
 */
public class ChatServer implements Runnable {
    private int port;
    private Thread thread;

    public final static int DEFAULT_PORT = 3333;//Puerto por defecto

    public ChatServer(int port) {
        this.port = port;
    }//Instancia de la clase creada con puerto

    //Funcion de arranque del servidor
    public void startServer() {
        if (thread == null)
            (thread = new Thread(this, "Server main thread")).start();
    }

    @Override
    public void run() { //Procesos a realizar por el servidor
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Chat server up, listening at " + port);
            while (true) {
                Socket socket = ss.accept();
                (new Thread(new ChatServerThread(socket))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Main que arranca el servidor y recibe por argumentos desde el cliente el puerto de conexion
    public static void main(String[] args) {
        int port = (args.length == 1) ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        ChatServer server = new ChatServer(port);
        server.startServer();
    }
}
