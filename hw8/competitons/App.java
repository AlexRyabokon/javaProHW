package org.hillel.hw8.competitons;

import org.hillel.hw8.competitons.obstacles.JumpWall;
import org.hillel.hw8.competitons.obstacles.Obstacle;
import org.hillel.hw8.competitons.obstacles.RunRoad;
import org.hillel.hw8.competitons.participants.Cat;
import org.hillel.hw8.competitons.participants.Human;
import org.hillel.hw8.competitons.participants.Participant;
import org.hillel.hw8.competitons.participants.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class App {

    public void competitionResult(Obstacle[] obstacles, Participant... participants) {
        LinkedHashSet<Participant> winners = new LinkedHashSet<>();

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                obstacles[j].overcome(participants[i]);

                if (participants[i].isOnDistance() == true) {
                    winners.add(participants[i]);
                }
            }
        }

        for (Participant p : winners) {
            System.out.println("The winners:  ");
            System.out.println(p.getName());
        }
    }

    public static void main(String[] args) {
        Obstacle[] obstacles = {new RunRoad(20), new JumpWall(2)};

        App app = new App();
        app.competitionResult(obstacles, new Robot("Robo1", 50, 5),
                new Human("Alex", 10, 1),
                new Cat("Catty", 10, 3));

    }

}
