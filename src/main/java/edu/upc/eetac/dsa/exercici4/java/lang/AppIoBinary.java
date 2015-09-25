package edu.upc.eetac.dsa.exercici4.java.lang;

import java.io.File;
import java.io.IOException;

/**
 * Created by User on 24/09/2015.
 */
public class AppIoBinary {


    public static void main(String[] args) throws IOException {
        BinaryIOClass testWrite = new BinaryIOClass(3, 7.5, 'a'); //creacion de objeto y asignacion de valores
        testWrite.saveToFile("test-io-binary"); //utilizacion de metodo creado en clase para crear archivo y almacenar datos
                            //asignacion de nombre al nuevo archivo

        BinaryIOClass testRead = BinaryIOClass.readFromFile("test-io-binary");//lectura de archivo
        System.out.println("integer = " + testRead.getInteger());
        System.out.println("decimal = " + testRead.getDecimal());
        System.out.println("char = " + testRead.getCharacter());

        File file = new File("test-io-binary"); //borrado del archivo
        file.delete();
    }
}
