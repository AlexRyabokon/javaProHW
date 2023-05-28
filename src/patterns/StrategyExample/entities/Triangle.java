package patterns.StrategyExample.entities;

public class Triangle extends Figure{

    private double base;
    private double height;

    public Triangle(double width, double height) {
        this.base = width;
        this.height = height;
    }

    @Override
    public double computeArea() {
        return strategy.computeArea(base, height);
    }
}
