package org.example;

import java.util.Arrays;

public class ArrayTasks {

    // Метод 1: Замена 0 на 1 и 1 на 0
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        System.out.println("Inverted array: " + Arrays.toString(array));
    }

    // Метод 2: Заполнение массива числами от 1 до 100
    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println("Filled array: " + Arrays.toString(array));
    }

    // Метод 3: Умножение элементов меньше 6 на 2
    public static int[] multiplyIfLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    // Метод 4: Заполнение диагоналей квадратного массива единицами
    public static void fillDiagonals(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1; // Главная диагональ
            matrix[i][n - i - 1] = 1; // Дополнительная диагональ
        }
        System.out.println("Matrix with filled diagonals:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Метод 5: Создание массива длины len и заполнение значением initialValue
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    // Метод 6: Поиск минимального и максимального значения в массиве
    public static void findMinMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        System.out.println("Min value: " + min + ", Max value: " + max);
    }

    // Метод 7: Проверка баланса массива
    public static boolean checkBalance(int[] array) {
        int totalSum = Arrays.stream(array).sum();
        int leftSum = 0;

        for (int num : array) {
            leftSum += num;
            if (leftSum == totalSum - leftSum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Тестирование методов:

        // Метод 1
        int[] binaryArray = {1, 0, 1, 0, 1, 1, 0};
        invertArray(binaryArray);

        // Метод 2
        fillArray();

        // Метод 3
        int[] predefinedArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Modified array: " + Arrays.toString(multiplyIfLessThanSix(predefinedArray)));

        // Метод 4
        int[][] squareMatrix = new int[5][5];
        fillDiagonals(squareMatrix);

        // Метод 5
        System.out.println("Created array: " + Arrays.toString(createArray(10, 5)));

        // Метод 6
        int[] randomArray = {3, -1, 7, 9, -5, 10};
        findMinMax(randomArray);

        // Метод 7
        int[] balanceArray1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] balanceArray2 = {1, 1, 1, 2, 1};
        System.out.println("Balance check (array1): " + checkBalance(balanceArray1));
        System.out.println("Balance check (array2): " + checkBalance(balanceArray2));
    }
}
