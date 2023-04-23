package homework19;

import java.util.Arrays;

public class ValueCalculator {

    final double[] arr;
    final int size;
    int halfSize;

    public ValueCalculator(int size) {
        this.size = Math.max(size, 1000000); // Мінімальний розмір масиву - 1 мільйон
        arr = new double[size];
        halfSize = size / 2;
    }

    public void startMethod() {
        long start = System.currentTimeMillis();

        Arrays.fill(arr, 1.0);

        double[] arr1 = new double[halfSize];
        double[] arr2 = new double[halfSize];
        System.arraycopy(arr, 0, arr1, 0, halfSize);
        System.arraycopy(arr, halfSize, arr2, 0, halfSize);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + halfSize) / 5) *
                        Math.cos(0.2f + (i + halfSize) / 5) * Math.cos(0.4f + (i + halfSize) / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, halfSize);
        System.arraycopy(arr2, 0, arr, halfSize, halfSize);

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }


    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator(1000000);
        ValueCalculator valueCalculator1 = new ValueCalculator(1000000);
        valueCalculator.startMethod();
        valueCalculator1.startMethod();
    }
}
