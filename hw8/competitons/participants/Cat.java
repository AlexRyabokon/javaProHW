package org.hillel.hw8.competitons.participants;

public class Cat extends Participant{

    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
    }

    @Override
    public void run(int distance) {
        if(distance <= maxRunDistance) {
            System.out.println(this.getName() + " пробіг " + distance + " метрів");
        } else {
            System.out.println(this.getName() + " не зміг пробігти " + distance + " метрів");
            this.setOnDistance(false);
        }
    }

    @Override
    public void jump(int height) {
        if(height <= maxJumpHeight) {
            System.out.println(this.getName() + " перестрибнув " + height + " метрів");
        } else {
            System.out.println(this.getName() + " не зміг перестрибнути " + height + " метрів");
            this.setOnDistance(false);
        }
    }
}
