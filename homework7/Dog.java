package org.hillel.homework7;

public class Dog extends Animal {

    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int numberOfDogs = 0;

    public Dog(String name, int age) {
        super(name, "Dog", age);
        numberOfDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(this.getName() + " ran " + distance + " meters");
        } else {
            System.out.println(this.getName() + " can`t run more than " + MAX_RUN_DISTANCE + " meters");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(this.getName() + " swam " + distance + " meters");
        } else {
            System.out.println(this.getName() + " cant swim more than " + MAX_SWIM_DISTANCE + " meters");
        }
    }

    public static int getNumberOfDogs() {
        return numberOfDogs;
    }


}