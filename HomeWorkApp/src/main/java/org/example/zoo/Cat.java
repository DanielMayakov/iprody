package org.example.zoo;

// Класс "Кот", наследуется от "Животное"
public class Cat extends Animal {
    private static int catCount = 0; // Счетчик котов

    // Конструктор
    public Cat(String name) {
        super(name, 200, 0); // У кота: бег 200 м., плавание 0 м.
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    // Метод для получения количества котов
    public static int getCatCount() {
        return catCount;
    }
}
