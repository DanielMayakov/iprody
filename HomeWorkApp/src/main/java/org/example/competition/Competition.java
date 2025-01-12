package org.example.competition;

public class Competition {

    public static void start(Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            boolean passedAllObstacles = true;

            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    System.out.println(participant.getName() + " выбывает из соревнований.");
                    passedAllObstacles = false;
                    break;
                }
            }

            if (passedAllObstacles) {
                System.out.println(participant.getName() + " успешно прошел все препятствия!");
            }
        }
    }

    public static void main(String[] args) {
        Participant[] participants = new Participant[]{
                new Human("Человек", 1000, 2),
                new Cat("Кот", 500, 3),
                new Robot("Робот", 2000, 1)
        };

        Obstacle[] obstacles = new Obstacle[]{
                new RunningTrack(800),
                new Wall(2)
        };

        start(participants, obstacles);
    }
}
