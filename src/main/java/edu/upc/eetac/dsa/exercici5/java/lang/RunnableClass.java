package edu.upc.eetac.dsa.exercici5.java.lang;

/**
 * Created by User on 26/09/2015.
 * Proceso (Thread)  2
 * El código es exactamente igual que en ThreadClass pero en este caso con la interfaz Runnable
 * Runnable utiliza la clase Thread y crea una instancia de tipo Thread
 */
public class RunnableClass implements Runnable {
    long lastExecution = 0;
    int counter = 0;

    //@Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long currentExecution = System.currentTimeMillis();
            long elapsed = (lastExecution == 0) ? 0 : currentExecution - lastExecution;
            lastExecution = currentExecution;
            System.out.println(Thread.currentThread().getName() + " elapsed = " + elapsed + " ms. [" + (++counter)+"]");
            long sleep = (long) (Math.random() * 2000);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
