package org.hillel.hw8.figures;

public class App {

    public static double sumOfAreas(Figurable... figurables) {
        double totalArea = 0;
        for (int i = 0; i < figurables.length; i++) {
            totalArea += figurables[i].getArea();
        }

        return totalArea;
    }


    public static void main(String[] args) {
        System.out.println(sumOfAreas(new Circle(5)));
    }
}
