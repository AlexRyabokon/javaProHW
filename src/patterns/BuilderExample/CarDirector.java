package patterns.BuilderExample;

import patterns.BuilderExample.entities.Car;
import patterns.BuilderExample.interfaces.Builder;

public class CarDirector {
    public Car buildCar(Builder builder) {
        builder.buildEngine();
        builder.buildBody();
        builder.buildWheels();
        builder.buildInterior();
        return builder.getCar();
    }
}
