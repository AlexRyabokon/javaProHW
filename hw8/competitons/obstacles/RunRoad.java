package org.hillel.hw8.competitons.obstacles;

import org.hillel.hw8.competitons.participants.Participant;

public class RunRoad extends Obstacle {

    private int distance;

    public RunRoad(int distance) {
        this.distance = distance;
    }

    @Override
    public void overcome(Participant participant) {
        participant.run(distance);
    }
}
