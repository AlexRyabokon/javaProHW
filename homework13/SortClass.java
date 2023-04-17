package homework13;

import java.util.Arrays;

public class SortClass {

    public static int[] bubbleArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleArray(new int[]{1, 5, 7, 3})));
        System.out.println(Arrays.toString(insertion(new int[]{1, 5, 7, 3})));
    }
}
