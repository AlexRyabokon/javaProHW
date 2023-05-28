package patterns.BuilderExample;

import patterns.BuilderExample.entities.Car;
import patterns.BuilderExample.interfaces.Builder;

public class SportsCarBuilder implements Builder {
    private Car car;

    public SportsCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("Sports Engine");
    }

    @Override
    public void buildBody() {
        car.setBody("Sports Body");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Sports Wheels");
    }

    @Override
    public void buildInterior() {
        car.setInterior("Sports Interior");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
