package org.example;

import java.util.Arrays;

public class ShakerSortExample {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 6, 2, 7, 4, 1};
        System.out.println("Before Sorting: " + Arrays.toString(array));

        shakerSort(array);

        System.out.println("After Sorting: " + Arrays.toString(array));
    }

    public static void shakerSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Если массив пустой или состоит из одного элемента, ничего не делаем.
        }

        boolean swapped;
        int start = 0;
        int end = array.length - 1;

        do {
            swapped = false;

            // Прямой проход (слева направо)
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            // Уменьшаем границу конца
            end--;

            // Обратный проход (справа налево)
            for (int i = end; i > start; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    swapped = true;
                }
            }

            // Увеличиваем границу начала
            start++;

        } while (swapped);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
