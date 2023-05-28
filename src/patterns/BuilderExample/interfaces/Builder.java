package patterns.BuilderExample.interfaces;

import patterns.BuilderExample.entities.Car;

public interface Builder {
    void buildEngine();
    void buildBody();
    void buildWheels();
    void buildInterior();
    Car getCar();
}
