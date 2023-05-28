package patterns.BuilderExample.entities;

public class Car {

    private String engine;
    private String body;
    private String wheels;
    private String interior;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", body='" + body + '\'' +
                ", wheels='" + wheels + '\'' +
                ", interior='" + interior + '\'' +
                '}';
    }
}
