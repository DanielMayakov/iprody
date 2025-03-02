package org.example.valueCalc;

import java.util.Arrays;

public class ValueCalculator {
    private static final int MIN_ARRAY_SIZE = 1_000_000; // Минимальный размер массива
    private final int size; // Размер массива
    private final float[] array; // Массив вещественных чисел

    public ValueCalculator(int size) {
        if (size < MIN_ARRAY_SIZE) {
            throw new IllegalArgumentException("Array size must be at least " + MIN_ARRAY_SIZE);
        }
        this.size = size;
        this.array = new float[size];
    }

    public void doCalc() {
        // Засекаем время старта
        long startTime = System.currentTimeMillis();

        // Заполняем массив единицами
        Arrays.fill(array, 1.0f);

        // Разделяем массив на две части
        int halfSize = size / 2;
        float[] part1 = new float[halfSize];
        float[] part2 = new float[halfSize];

        System.arraycopy(array, 0, part1, 0, halfSize);
        System.arraycopy(array, halfSize, part2, 0, halfSize);

        // Создаем два потока для обработки частей массива
        Thread thread1 = new Thread(() -> processArray(part1));
        Thread thread2 = new Thread(() -> processArray(part2));

        // Запускаем потоки
        thread1.start();
        thread2.start();

        // Дожидаемся завершения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread execution was interrupted.");
            return;
        }

        // Склеиваем массивы обратно в исходный массив
        System.arraycopy(part1, 0, array, 0, halfSize);
        System.arraycopy(part2, 0, array, halfSize, halfSize);

        // Вычисляем затраченное время
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }

    private void processArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
    }

    public static void main(String[] args) {
        int arraySize = 1_000_000; // Размер массива
        ValueCalculator calculator = new ValueCalculator(arraySize);
        calculator.doCalc();
    }
}

