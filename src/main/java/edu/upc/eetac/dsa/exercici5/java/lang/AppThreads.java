package edu.upc.eetac.dsa.exercici5.java.lang;

/**
 * Created by Jesús Tardío on 26/09/2015.
 */
public class AppThreads {

    public static void main(String[] args) throws InterruptedException {

        /**Creación de objetos de tipo ThreadClass y RunnableClass.
         En el caso del segundo el objeto es tipo Thread ya que Runnable es una interfaz de dicha clase**/
        ThreadClass threadClass = new ThreadClass("thread class");
        Thread thread = new Thread(new RunnableClass(), "runnable class");

        //Arranca los 2 procesos
        threadClass.start();
        thread.start();

        //El método join lo que hace es que un thread espere que el que está en funcionamiento termine sus procesos
        threadClass.join();
        thread.join();

        System.out.println("Se acabó.");
    }
}