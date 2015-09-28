package edu.upc.eetac.dsa.exercici6.java.lang;

/**
 * Created by User on 26/09/2015.
 */
public class Consumer implements Runnable {
    private Buffer buffer = null;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    } //asigna un buffer para leer

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        char c;
        while ((c = buffer.get()) != '\n') {
            // Uncomment to log what is reading the thread
             System.out.println(Thread.currentThread().getName() + " reads " + c);
            sb.append(c); //Añade a la cadena sb el valor c
        }
        System.out.println(sb);
    }
}