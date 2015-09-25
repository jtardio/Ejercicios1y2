package edu.upc.eetac.dsa.exercici2.java.lang;

/**
 * Created by User on 23/09/2015.
 */
public class Circle extends AbstractShape {

    private double radio;

    //Constructor con super??

    public Circle(double radio) {

        super("circle");
    }

    //Obterner y asignar un radio al objeto de clase Circle
    public double getradio() {
        return radio;
    }

    public void setradio(double radio) {
        this.radio = radio;
    }


    //Retorna el area geométrica del Circle

    public double area() {
        return Math.PI * radio * radio;
    }
}

