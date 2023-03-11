package org.hillel.homework7;

import static org.hillel.homework7.Animal.getNumberOfAnimals;
import static org.hillel.homework7.Cat.getNumberOfCats;
import static org.hillel.homework7.Dog.getNumberOfDogs;

public class App {
    public static void main(String[] args) {
        Animal cat = new Cat("Barsik", 8);
        Animal dog = new Dog("Bobik", 12);
        dog.run(501);
        cat.run(500);
        cat.run(10);
        cat.swim(2);
        System.out.println("Cats "+getNumberOfCats());
        System.out.println("Dogs "+getNumberOfDogs());
        System.out.println("All Animals "+getNumberOfAnimals());
    }
}
