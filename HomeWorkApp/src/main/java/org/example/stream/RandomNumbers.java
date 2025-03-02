package org.example.stream;

import java.util.*;
import java.util.stream.Collectors;

public class RandomNumbers {
    public static void generateAndProcess() {
        Random random = new Random();

        // Генерация 100 случайных чисел от 1 до 1000
        List<Integer> randomNumbers = random.ints(100, 1, 1001).boxed().collect(Collectors.toList());

        // Нахождение топ-10 минимальных значений
        List<Integer> top10Min = randomNumbers.stream()
                .sorted()
                .distinct()
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Топ-10 минимальных значений (по убыванию): " + top10Min);
    }
}

