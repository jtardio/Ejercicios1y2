package edu.upc.eetac.dsa.exercici9.java.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Created by User on 27/09/2015.
 */
public class ChatServerThread implements Runnable {
    private static List<ChatServerThread> threadList = Collections.synchronizedList(new ArrayList<ChatServerThread>());
    //Crea una lista de threads para contener todos los procesos de los chats

    private Socket socket = null;
    private String username = null;
    private BufferedReader reader = null;
    private PrintWriter writer = null;

    //Constructor de la clase que recibe el socket y crea los atributos de lectura y escritura
    public ChatServerThread(Socket socket) throws IOException {
        this.socket = socket;

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            String[] msg = null;
            do {
                msg = reader.readLine().split(" ", 2);
                //Procesos de los diferentes tipos de mensaje
                if (msg[0].equals("JOIN")) {
                    username = msg[1];
                    Thread.currentThread().setName(username + " thread");
                    threadList.add(this);
                    broadcast("estoy dentro.");

                    //Envio de mensaje
                } else if (msg[0].equals("MESSAGE")) {
                    broadcast(msg[1]);
                }
            } while (!msg[0].equals("LEAVE"));//Palabra clave para salir del chat

            threadList.remove(this);//Una vez abandona el chat elimina los threads generados
            broadcast("me piro.");
            socket.close();//Cierra conexion
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Funcion que envia los mensajes a todos los integrantes del chat
    private void broadcast(String msg) {
        for (ChatServerThread t : threadList)
            t.send(username + "> " + msg);
    }

    //Funcion para enviar mensaje de texto
    private void send(String msg) {
        writer.println(msg);
        writer.flush();
    }
}
