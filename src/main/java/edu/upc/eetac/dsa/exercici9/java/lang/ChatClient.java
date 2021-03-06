package edu.upc.eetac.dsa.exercici9.java.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * Created by User on 27/09/2015.
 */
public class ChatClient implements Runnable {
    private class ReaderThread implements Runnable {
        BufferedReader reader = null;

        public ReaderThread(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            String msg = null;
            try {
                while ((msg = reader.readLine()) != null)
                    System.out.println(msg);
            } catch (IOException e) {
                if (!socket.isClosed())
                    e.printStackTrace();
            }
        }
    }

    private String server;
    private int port;
    private Socket socket = null;
    private BufferedReader reader = null;
    private PrintWriter writer = null;

    //Constructor para instanciar el cliente con puerto por defecto
    public ChatClient(String server) {
        this(server, ChatServer.DEFAULT_PORT);
    }

    //constructor con nombre de servidor y puerto
    public ChatClient(String server, int port) {
        this.server = server;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//Entrada de datos de usuario
            System.out.println("Enter your username: ");
            String username = reader.readLine();
            join(username); //Conexion al chat

            System.out.println("start chat");
            String msg = null;
            while ((msg = reader.readLine()).length() != 0) {
                send(msg);
            }
            leave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void join(String username) throws IOException { //Funcion para unirse al chat
        socket = new Socket(server, port);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        (new Thread((new ReaderThread(reader)))).start();
        writer = new PrintWriter(socket.getOutputStream());

        writer.println("JOIN " + username);
        writer.flush();
    }

    private void leave() throws IOException {//Funcion para abandonar chat
        writer.println("LEAVE");
        writer.flush();

        socket.close();
    }

    private void send(String msg) {//Funcion para agregar mensajes
        writer.println("MESSAGE " + msg);
        writer.flush();
    }

    public static void main(String[] args) {//Main que inicia la sesion por parámetros
        if (args.length < 2) {
            System.err.println("You have to pass the server name and the server port");
            System.exit(-1);
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);
        ChatClient client = new ChatClient(server, port);
        (new Thread(client)).start();
    }
}
