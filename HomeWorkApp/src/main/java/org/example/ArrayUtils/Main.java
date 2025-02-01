package org.example.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Пример массива
        String[] array = {"A", "B", "C", "D", "E"};

        // Меняем пары местами
        ArrayUtils.swapPairs(array);
        System.out.println("После swapPairs: " + Arrays.toString(array));

        // Преобразуем массив в List
        List<String> list = ArrayUtils.toList(array);
        System.out.println("List: " + list);
    }
}

