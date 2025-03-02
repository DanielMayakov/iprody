package org.example.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionFilter {
    public static <T> Collection<T> filterCollection(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}

