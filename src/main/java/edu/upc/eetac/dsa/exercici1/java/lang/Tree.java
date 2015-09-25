package edu.upc.eetac.dsa.exercici1.java.lang;

/**
 * Clase Tree con constructores .
 */
public class Tree {
    private int height;
    private String name;

//Constructores

    public Tree() {
        this(0, null);
    }

    public Tree(int height) {
        this(height, null);
    }

    public Tree(String name) {
        this(0, name);
    }

    public Tree(int height, String name) {
        this.height = height;
        this.name = name;
    }

//Función para contruir y retornar la frase que devuelve la App

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Un ");

        if (name == null)
            sb.append("árbol");
        else
            sb.append(name);
        if (height > 0)
            sb.append(" de ").append(height).append(" metros");
        return sb.toString();
    }


}
