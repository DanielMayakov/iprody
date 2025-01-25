package org.example.list;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // --- Задача 1 ---

        // Пример для countOccurance
        List<String> words = Arrays.asList("cat", "dog", "bird", "cat", "dog", "cat");
        System.out.println("Count of 'cat': " + ListUtils.countOccurance(words, "cat"));

        // Пример для toList
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Converted to List: " + ListUtils.toList(numbers));

        // Пример для findUnique
        List<Integer> numList = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println("Unique numbers: " + ListUtils.findUnique(numList));

        // Пример для calcOccurance
        System.out.println("Word occurrences:");
        ListUtils.calcOccurance(words);

        // Пример для findOccurance
        System.out.println("Find occurrences:");
        System.out.println(ListUtils.findOccurance(words));


        // --- Задача 2 ---

        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в телефонный справочник
        phoneBook.add(new Record("John", "123-456-789"));
        phoneBook.add(new Record("Jane", "987-654-321"));
        phoneBook.add(new Record("John", "555-555-555"));

        // Ищем первую запись по имени
        System.out.println("Find John: " + phoneBook.find("John"));

        // Ищем все записи по имени
        System.out.println("Find all Johns: " + phoneBook.findAll("John"));

        // Выводим весь справочник
        System.out.println("Phone book: " + phoneBook);
    }
}

