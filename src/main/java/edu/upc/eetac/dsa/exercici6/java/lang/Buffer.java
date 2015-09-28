package edu.upc.eetac.dsa.exercici6.java.lang;

/**
 * Created by User on 26/09/2015.
 */
public class Buffer {
    private final static int BUFFER_SIZE = 32;
    private char[] buffer;
    private int head;
    private int tail;

    public Buffer() {
        buffer = new char[BUFFER_SIZE]; //Crea buffer de tamaño 32 posiciones
        this.head = 0;
        this.tail = 0;
    }

    //Metodo para obtener el contenido de una posicion del buffer
    public synchronized char get() {
        while (isEmpty())
            try {
                wait();
            } catch (InterruptedException e) {
            }
        char c = buffer[head++];
        if (head == buffer.length) {
            head = 0;
        }

        notifyAll();
        return c;
    }

    public synchronized void put(char c) {
        while (isFull())
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        buffer[tail++] = c;
        if (tail == buffer.length) {
            tail = 0;
        }
        notifyAll();
    }

    //Métodos indicadores de si el buffer está vacío o lleno
    private boolean isEmpty() {
        return head == tail;
    }

    private boolean isFull() {
        if (tail + 1 == head) {
            return true;
        }
        if (tail == (buffer.length - 1) && head == 0) {
            return true;
        }
        return false;
    }
}