package edu.upc.eetac.dsa.exercici6.java.lang;

/**
 * Created by User on 26/09/2015.
 */
public class AppSynchronization {
    public static void main(String[] args) {
        String line = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor.\n";
        Buffer buffer = new Buffer();//creacion del buffer de 32 posiciones

//Puesto que estas dos clases implementan de Runnable se han de crear con un constructor de Thread
// que contiene los constructores de las 2 clases

        //creacion del objeto producer y llamada al constructor de producer pasandole la linea a escribir y el buffer
        Thread producer = new Thread(new Producer(buffer, line), "producer");
        //creacion del objeto consumer pasandole como atributo el buffer
        Thread consumer = new Thread(new Consumer(buffer), "consumer");

        //Arranque de los 2 threads
        consumer.start();
        producer.start();
    }
}
