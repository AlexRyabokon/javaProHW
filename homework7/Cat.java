package org.hillel.homework7;

import static org.hillel.homework7.Dog.getNumberOfDogs;

public class Cat extends Animal{
    private static final int MAX_RUN_DISTANCE = 200;
    private static int numberOfCats = 0;

    public Cat(String name, int age) {
        super(name, "Cat", age);
        numberOfCats++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(this.getName() + " ran " + distance + " meters");
        } else {
            System.out.println(this.getName() + " cannot run more than " + MAX_RUN_DISTANCE + " meters");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(this.getType() + " names "+ this.getName() + " cannot swim");
    }

    public static int getNumberOfCats() {
        return numberOfCats;
    }


}
