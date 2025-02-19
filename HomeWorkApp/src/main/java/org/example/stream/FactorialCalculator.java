package org.example.stream;

import java.util.stream.IntStream;

public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Число должно быть неотрицательным.");
        return IntStream.rangeClosed(1, n) // Создаем поток чисел от 1 до n включительно
                .asLongStream()   // Преобразуем поток в LongStream для предотвращения переполнения
                .reduce(1, (a, b) -> a * b); // Перемножаем все числа в потоке
    }
}

