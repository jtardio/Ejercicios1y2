package edu.upc.eetac.dsa.exercici2.java.lang;

import edu.upc.eetac.dsa.exercici2.java.lang.Shape;

/**
 * Clase que designa que forma tiene figura e incluye una función que retorna la frase con el tipo correspondiente creado
 * Autor: Jesús Tardío
 */
public abstract class AbstractShape implements Shape {

    private String type;

    //Constructor
    public AbstractShape(String type) {

        this.type = type;
    }

    @Override
    public String toString() {
        return "I'm a " + type;
    }
}
