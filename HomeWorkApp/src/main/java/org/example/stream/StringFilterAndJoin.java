package org.example.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringFilterAndJoin {
    public static String filterAndJoinStrings(Collection<String> strings, Predicate<String> predicate) {
        return strings.stream()
                .filter(predicate)
                .collect(Collectors.joining("|"));
    }
}
