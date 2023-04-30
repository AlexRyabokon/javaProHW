package containerFruits.abstracts;

public abstract class Fruit {

   private float weight;

    public Fruit(float weight) {
        this.weight = weight<0?0:weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
