package org.hillel.hw8.competitons.participants;

public abstract class Participant {
    private String name;
    protected int maxRunDistance;
    protected int maxJumpHeight;
    public boolean isOnDistance() {
        return onDistance;
    }
    public void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean onDistance = true;

    public Participant(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public abstract void run(int distance);

    public abstract void jump(int height);
}
