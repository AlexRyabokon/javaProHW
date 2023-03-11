package org.hillel.homework7;

public abstract class Animal {
    private String name; // Animals name
    private String type; //Animals type
    private int age; // Animals age
    private static int numberOfAnimals = 0; // Animals counter

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        numberOfAnimals++;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // running method
    public void run(int distance) {
        System.out.println(this.name + " ran " + distance + " meters");
    }

    //swimming method
    public void swim(int distance) {
        System.out.println(this.name + " swam " + distance + " meters");
    }

    // count of animals show method
    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }
}



