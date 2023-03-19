package org.hillel.hw9;

import org.hillel.hw9.exceptions.ArrayDataException;
import org.hillel.hw9.exceptions.ArraySizeException;

public class ArrayValueCalculator {
    public static int doCalc(Object[][] arr) throws ArraySizeException, ArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new ArraySizeException("Array size must be 4x4!" + " Your array size is:  " + arr.length);
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt((String) arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + arr[i][j]);
                }
            }
        }
        return sum;
    }
}
