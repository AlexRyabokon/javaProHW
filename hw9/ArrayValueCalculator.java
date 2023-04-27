package org.hillel.hw9;

import org.hillel.hw9.exceptions.ArrayDataException;
import org.hillel.hw9.exceptions.ArraySizeException;

//Class calculates the sum of all elements of some String matrix/ Size of matrix should be 4x4
//any element should contain any integer.
//Сan throw exceptions if conditions are not met
public class ArrayValueCalculator {
    public static int doCalc(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != 4 || matrix[i].length != 4) {
                throw new ArraySizeException("Array size must be 4x4!" + " Your #" + i + " array size is:  " + matrix[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + matrix[i][j]);
                }
            }
        }
        return sum;
    }
}
