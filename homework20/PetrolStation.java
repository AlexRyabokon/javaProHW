package homework20;

import java.util.concurrent.Semaphore;

public class PetrolStation {

    private int amount;
    private final Semaphore semaphore = new Semaphore(3);


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PetrolStation(int amount) {
        if (amount <= 0) {
            throw new RuntimeException("PetrolStation is empty");
        } else {
            this.amount = amount;
        }
    }

    public void doRefuel(int fuel) {
        try {
            semaphore.acquire();
            Thread.sleep((long) (Math.random() * 7000 + 3000));
            synchronized (this) {
                amount -= fuel;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }


    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(5);
        petrolStation.doRefuel(1);
        System.out.println(petrolStation.getAmount());
    }
}
