package org.example.exceptions;

public class ArrayValueCalculator {

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        // Проверяем размер массива
        if (array.length != 4 || !allRowsHaveSizeFour(array)) {
            throw new ArraySizeException("Размер массива должен быть 4x4.");
        }

        int sum = 0;

        // Проходим по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Преобразуем строку в число и добавляем к сумме
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось, выбрасываем исключение с деталями
                    throw new ArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j], e);
                }
            }
        }

        return sum;
    }

    // Метод для проверки, что все строки массива имеют длину 4
    private static boolean allRowsHaveSizeFour(String[][] array) {
        for (String[] row : array) {
            if (row.length != 4) {
                return false;
            }
        }
        return true;
    }
}
