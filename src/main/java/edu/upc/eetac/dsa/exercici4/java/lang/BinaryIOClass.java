package edu.upc.eetac.dsa.exercici4.java.lang;

import java.io.*;
/**
 * Created by User on 24/09/2015.
 */
public class BinaryIOClass {
    private int integer;
    private double decimal;
    private char character;

    //Constructor de clase

    public BinaryIOClass(int integer, double decimal, char character) {
        this.integer = integer;
        this.decimal = decimal;
        this.character = character;
    }

    //Gets y Sets de todas las variables de clase

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    //Metodo que crea el archivo y almacena en el los valores de las tres variables

    public void saveToFile(String filename) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
        dos.writeInt(integer);
        dos.writeDouble(decimal);
        dos.writeChar(character);
        dos.close();
    }

    //Metodo que lee el archivo creado por el anterior metodo y almacena los datos para enviarlos al main

    public final static BinaryIOClass readFromFile(String filename) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filename));
        int integer = dis.readInt();
        double decimal = dis.readDouble();
        char character = dis.readChar();

        return new BinaryIOClass(integer, decimal, character);
    }
}
