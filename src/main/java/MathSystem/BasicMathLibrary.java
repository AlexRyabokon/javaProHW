package MathSystem;

public class BasicMathLibrary {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (a == 0 || b == 0) throw new RuntimeException("You cant use 0 in divide operations!");
        return (double) a / b;
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double sqrt(double a) {
        if (a < 0) throw new RuntimeException("The square root of a negative number does not exist");
        return Math.sqrt(a);
    }

    public static int abs(int a) {
        return Math.abs(a);
    }
}
