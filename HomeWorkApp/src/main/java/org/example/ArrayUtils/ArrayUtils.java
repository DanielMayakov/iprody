package org.example.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

    // Метод для изменения пар элементов в массиве
    public static <T> void swapPairs(T[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i += 2) {
            // Меняем элементы местами
            T temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    // Метод для преобразования массива в List
    public static <T> List<T> toList(T[] array) {
        return Arrays.asList(array);
    }
}
