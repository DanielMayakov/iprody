package org.example.list;

import java.util.*;
import java.util.stream.Collectors;

public class ListUtils {

    // Метод для преобразования массива в список
    public static List<Integer> toList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    // Метод для нахождения уникальных чисел в списке
    public static List<Integer> findUnique(List<Integer> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    // Метод для подсчета количества вхождений каждого слова в списке
    public static void calcOccurance(List<String> list) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : list) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Выводим результат в консоль
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Метод для подсчета количества вхождений каждого слова и возврата результата в виде списка объектов
    public static List<WordOccurrence> findOccurance(List<String> list) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : list) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<WordOccurrence> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            result.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    // Метод для подсчета количества вхождений строки в список
    public static int countOccurance(List<String> list, String word) {
        int count = 0;
        for (String s : list) {
            if (s.equals(word)) { // Сравниваем каждую строку с заданным словом
                count++;
            }
        }
        return count; // Возвращаем итоговое количество
    }
}

