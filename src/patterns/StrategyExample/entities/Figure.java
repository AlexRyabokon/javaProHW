package patterns.StrategyExample.entities;

import patterns.StrategyExample.interfaces.Strategy;

public abstract class Figure {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public abstract double computeArea();
}
