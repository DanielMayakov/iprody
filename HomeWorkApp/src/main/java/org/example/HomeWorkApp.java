package org.example;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

        System.out.println(isSumInRange(10, 5));
        printNumberSign(-5);
        System.out.println(isNegative(-5));
        printStringMultipleTimes("Hello", 3);
        System.out.println(isLeapYear(2020));
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = -5;
        int sum = a + b;
        System.out.println(sum >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void printColor() {
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 7;
        int b = 10;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }


    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void printNumberSign(int number) {
        System.out.println(number >= 0 ? "Положительное" : "Отрицательное");
    }


    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}