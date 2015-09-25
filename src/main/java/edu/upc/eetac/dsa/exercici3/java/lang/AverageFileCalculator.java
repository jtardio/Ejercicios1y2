package edu.upc.eetac.dsa.exercici3.java.lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * Created by User on 24/09/2015.
 */
public class AverageFileCalculator {

    public final static double average(String file) throws FileParsingException, BigNumberException {
        double counter = 0d;
        double sum = 0d;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file)); //objeto de buffer de lectura
            String line = null;//variable donde almacenar la frase que se lee en cada linea

            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line); //convierte strings a enteros
                    if (number > 1000)
                        throw new BigNumberException("Number greater than 1000 at line " + (int) (++counter));
                    sum += number;
                    counter++;
                } catch (NumberFormatException e) {
                    throw new FileParsingException(e.getMessage());
                }
            }
        } catch (java.io.IOException e) {
            throw new FileParsingException(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("warning: can not close file.");
            }
        }

        return sum / counter;
    }
}
