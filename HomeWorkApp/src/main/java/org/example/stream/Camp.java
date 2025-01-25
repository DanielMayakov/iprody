package org.example.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Camp {
    private final List<Boyscout> boyscouts;

    public Camp(List<Boyscout> boyscouts) {
        this.boyscouts = boyscouts;
    }

    public Map<Boyscout.Team, List<Boyscout>> split() {
        return boyscouts.stream()
                .collect(Collectors.groupingBy(
                        Boyscout::getTeam,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Boyscout::getAge).reversed())
                                        .collect(Collectors.toList())
                        )
                ));
    }
}
