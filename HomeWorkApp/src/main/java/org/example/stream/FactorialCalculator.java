package org.example.stream;

public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Число должно быть неотрицательным.");
        return n == 0 ? 1 : n * factorial(n - 1);
    }
}

