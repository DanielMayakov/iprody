package org.example.stream;

import java.util.*;
import java.util.stream.Collectors;

public class NumberSorter {
    public enum SortDirection {
        ASC, DESC
    }

    public static List<Integer> sortNumbers(Collection<Integer> numbers, SortDirection direction) {
        return numbers.stream()
                .distinct()
                .sorted(direction == SortDirection.ASC ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
