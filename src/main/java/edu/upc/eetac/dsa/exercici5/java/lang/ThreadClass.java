package edu.upc.eetac.dsa.exercici5.java.lang;

/**
 * Created by User on 25/09/2015.
 * Proceso (Thread)  1
 */
public class ThreadClass extends Thread {
    long lastExecution = 0;
    int counter = 0; //Número de veces que se realiza el proceso del thread

    //Constructor del thread. Utiliza el constructor de la clase Thread que ya existe en java
    public ThreadClass(String name) {
        super(name);
    }

    //Función de ejecución del thread
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long currentExecution = System.currentTimeMillis(); //almacena el tiempo actual
            long elapsed = (lastExecution == 0) ? 0 : currentExecution - lastExecution; //calcula el tiempo transcurrido desde la ultima escritura
            lastExecution = currentExecution;
            System.out.println(getName() + " elapsed = " + elapsed + " ms. [" + (++counter) + "]"); //Muestra el nombre
            long sleep = (long) (Math.random() * 2000); //crea el numero de milisegundos que va a dormir el thread
            try {
                Thread.sleep(sleep); //manda a dormir el thread el tiempo designado anteriormente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
