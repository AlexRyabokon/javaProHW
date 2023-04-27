package org.hillel.hw9;

import org.hillel.hw9.exceptions.ArrayDataException;

import static org.hillel.hw9.ArrayValueCalculator.doCalc;

//Main App class which shows main behavior of this app
public class App {
    public static void main(String[] args) throws ArrayDataException {

        String[][] matrix = {{"1", "2", "3", "4"},
                {"4", "5", "d", "5"},
                {"4", "5", "6", "4"},
                {"4", "5", "6", "5"}};
        int sum = doCalc(matrix);
        System.out.println("Sum is: " + sum);

    }
}
