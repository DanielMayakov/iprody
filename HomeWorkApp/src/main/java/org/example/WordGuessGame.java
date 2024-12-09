package org.example;

import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {

    private static final String[] WORDS = {
            "apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
    };

    public static void main(String[] args) {
        // Генерация случайного слова
        Random random = new Random();
        String secretWord = WORDS[random.nextInt(WORDS.length)];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра: Угадайте слово!");

        while (true) {
            System.out.print("Введите ваше слово: ");
            String userGuess = scanner.nextLine();

            if (userGuess.equalsIgnoreCase(secretWord)) {
                System.out.println("Поздравляем! Вы угадали слово!");
                break;
            } else {
                // Показать буквы, которые стоят на своих местах
                String feedback = getFeedback(secretWord, userGuess);
                System.out.println("Неверно! Подсказка: " + feedback);
            }
        }
    }

    private static String getFeedback(String secretWord, String userGuess) {
        StringBuilder feedback = new StringBuilder();
        int maxLength = 15; // Длина подсказки

        for (int i = 0; i < maxLength; i++) {
            if (i < secretWord.length() && i < userGuess.length()
                    && secretWord.charAt(i) == userGuess.charAt(i)) {
                feedback.append(secretWord.charAt(i));
            } else {
                feedback.append("#");
            }
        }
        return feedback.toString();
    }

    public static int findSymbolOccurrence(String str, char symbol) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        String reversed = stringReverse(str);
        return str.equalsIgnoreCase(reversed);
    }

}
