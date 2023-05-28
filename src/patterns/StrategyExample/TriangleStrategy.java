package patterns.StrategyExample;

import patterns.StrategyExample.interfaces.Strategy;

public class TriangleStrategy implements Strategy {
    @Override
    public double computeArea(double a, double b) {
        return 0.5 * a * b;
    }
}
