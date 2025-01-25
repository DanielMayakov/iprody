package org.example.exceptions;

public class Main {
    public static void main(String[] args) {
        // Пример корректного массива 4x4
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример массива неправильного размера
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        // Пример массива с некорректными данными
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Результат для корректного массива: " + ArrayValueCalculator.doCalc(correctArray));
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            System.out.println("Результат для массива неправильного размера: ");
            System.out.println(ArrayValueCalculator.doCalc(wrongSizeArray));
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            System.out.println("Результат для массива с некорректными данными: ");
            System.out.println(ArrayValueCalculator.doCalc(invalidDataArray));
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

