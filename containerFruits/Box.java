package containerFruits;

import containerFruits.abstracts.Fruit;
import containerFruits.interfaces.Weightable;

import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit> implements Weightable{

    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public boolean addFruit(T fruit){
        if (fruit==null){
            throw new RuntimeException("Invalid input parameter");
        }

        fruits.add(fruit);
        return true;
    }

    public boolean addFruits(T[] fruits){
        if (fruits == null || fruits.length==0){
            throw new RuntimeException("Invalid input parameter");
        }

        Collections.addAll(this.fruits, fruits);
        return true;
    }


    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        float weight = fruits.size() * fruits.get(0).getWeight();
        return weight;
    }

    public boolean compare(Box<?> box) {
        if (this.getWeight() == box.getWeight()) {
            return true;
        }
        return false;
    }

    public void merge(Box<T> box) {
        if (this.getClass() == box.getClass()) {
            addFruits((T[]) box.getFruits().toArray());
            box.clearBox();
        } else {
            System.out.println("Cannot merge boxes of different types.");
        }
    }

    public void clearBox() {
        fruits.clear();
    }
}
