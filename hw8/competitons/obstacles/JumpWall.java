package org.hillel.hw8.competitons.obstacles;

import org.hillel.hw8.competitons.participants.Participant;

public class JumpWall extends Obstacle{

    private int height;

    public JumpWall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Participant participant) {
        participant.jump(height);
    }
}
