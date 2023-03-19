package org.hillel.hw8.figures;

public class Square implements Figurable{
    private double sideLengthA;
    private double sideLengthB;

    public Square(double sideLengthA, double sideLengthB) {
        this.sideLengthA = sideLengthA;
        this.sideLengthB = sideLengthB;
    }

    @Override
    public double getArea() {
        return sideLengthA * sideLengthB;
    }
}
