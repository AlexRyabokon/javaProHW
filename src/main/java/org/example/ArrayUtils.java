package org.example;

public class ArrayUtils {
    public static int[] extractElementsAfterLastFour(int[] array) {
        int lastFourIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastFourIndex = i;
            }
        }

        if (lastFourIndex == -1) {
            throw new RuntimeException("There is no 4 in the array!");
        }

        int[] result = new int[array.length - lastFourIndex - 1];
        System.arraycopy(array, lastFourIndex + 1, result, 0, result.length);
        return result;
    }
}
