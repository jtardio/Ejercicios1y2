package edu.upc.eetac.dsa.exercici6.java.lang;

/**
 * Created by User on 26/09/2015.
 */
public class Producer implements Runnable {
    private Buffer buffer = null;
    private String line = null;

    public Producer(Buffer buffer, String line) {
        this.buffer = buffer;
        this.line = line; //linea a escribir en el buffer
    }

    @Override
    public void run() {
        char chars[] = line.toCharArray();
        for (char c : chars) {
            buffer.put(c);
            // Uncomment to log what is writing the thread
             System.out.println(Thread.currentThread().getName() + " writes " + c);
        }
    }
}