package org.example;

import java.util.Arrays;

public class ArrayCopyExample {

    public static void main(String[] args) {
        // Пример 1
        int[] source1 = {1, 2, 3, 4};
        int[] target1 = {};
        target1 = arrayCopy(source1, target1);
        System.out.println("Result: " + Arrays.toString(target1));

        // Пример 2
        int[] source2 = {1, 2, 3, 4};
        int[] target2 = {5, 6, 7};
        target2 = arrayCopy(source2, target2);
        System.out.println("Result: " + Arrays.toString(target2));
    }

    public static int[] arrayCopy(int[] source, int[] target) {
        if (source == null || source.length == 0) {
            return target; // Если исходный массив пуст, возвращаем целевой как есть.
        }

        // Найдем последний заполненный индекс в целевом массиве.
        int lastIndex = target.length;

        // Создаем новый массив для объединения.
        int[] result = new int[lastIndex + source.length];

        // Копируем элементы из целевого массива.
        System.arraycopy(target, 0, result, 0, lastIndex);

        // Копируем элементы из исходного массива.
        System.arraycopy(source, 0, result, lastIndex, source.length);

        return result;
    }
}
