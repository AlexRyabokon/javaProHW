package coffee.order;

import java.util.Objects;

public class Order {
    private int number;
    private String name;

    public Order(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public Order(int number, String name) {
        this.number = number < 0 ? 0 : number;
        this.name = Objects.requireNonNull(name, "Name cannot be null");;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
