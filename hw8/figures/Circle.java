package org.hillel.hw8.figures;

public class Circle implements Figurable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius,2)*Math.PI;
    }
}
