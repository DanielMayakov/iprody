package org.example.stream;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Boyscout> scouts = Arrays.asList(
                new Boyscout("John", 15, Boyscout.Team.RED),
                new Boyscout("Mike", 12, Boyscout.Team.BLUE),
                new Boyscout("Alex", 14, Boyscout.Team.RED),
                new Boyscout("Tom", 16, Boyscout.Team.BLUE),
                new Boyscout("Sam", 11, Boyscout.Team.GREEN)
        );

        Camp camp = new Camp(scouts);
        Map<Boyscout.Team, List<Boyscout>> groupedScouts = camp.split();

        groupedScouts.forEach((team, members) -> {
            System.out.println(team + ": " + members);
        });
    }
}

