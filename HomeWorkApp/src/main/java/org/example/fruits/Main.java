package org.example.fruits;

public class Main {
    public static void main(String[] args) {
        // Создаем коробку с яблоками
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        // Создаем коробку с апельсинами
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        // Выводим вес коробок
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        // Сравниваем коробки
        System.out.println("Коробки равны по весу? " + appleBox.compare(orangeBox));

        // Пересыпаем яблоки из одной коробки в другую
        Box<Apple> anotherAppleBox = new Box<>();
        appleBox.transfer(anotherAppleBox);

        System.out.println("Вес первой коробки с яблоками после пересыпания: " + appleBox.getWeight());
        System.out.println("Вес второй коробки с яблоками после пересыпания: " + anotherAppleBox.getWeight());
    }
}
