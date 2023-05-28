package patterns.StrategyExample;

import patterns.StrategyExample.interfaces.Strategy;

public class RectangleStrategy implements Strategy {

    @Override
    public double computeArea(double a, double b) {
        return a*b;
    }
}
