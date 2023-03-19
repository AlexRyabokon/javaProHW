package org.hillel.hw9;

import org.hillel.hw9.exceptions.ArrayDataException;
import org.hillel.hw9.exceptions.ArraySizeException;

import static org.hillel.hw9.ArrayValueCalculator.doCalc;

public class App {
    // In commented code I show another method of throwing exceptions
    
    public static void main(String[] args) throws ArrayDataException, ArrayDataException {
        /*try {*/
        String[][] arr = {{"1", "2", "3", "4"}, {"4", "5", "6", "5"},
                {"4", "5", "6", "5"}};
        int sum = doCalc(arr);
        System.out.println("Sum is: " + sum);
      /*  } catch (ArrayDataException e) {
            System.out.println("Error: " + e.getMessage()); // Output: Error: Invalid data in cell
        } catch (ArraySizeException e){
            System.out.println("Error: " + e.getMessage()); // Output: "Error: Array size must be 4x4
        }*/
    }
}
