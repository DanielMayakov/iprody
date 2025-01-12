package org.example.zoo;

// Класс "Собака", наследуется от "Животное"
public class Dog extends Animal {
    private static int dogCount = 0; // Счетчик собак

    // Конструктор
    public Dog(String name) {
        super(name, 500, 10); // У собаки: бег 500 м., плавание 10 м.
        dogCount++;
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
        if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }

    // Метод для получения количества собак
    public static int getDogCount() {
        return dogCount;
    }
}
