package org.example.zoo;

// Абстрактный класс "Животное"
abstract class Animal {
    protected String name; // Имя животного
    protected int maxRunDistance; // Максимальная дистанция для бега
    protected int maxSwimDistance; // Максимальная дистанция для плавания

    // Конструктор
    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    // Абстрактные методы для бега и плавания
    public abstract void run(int distance);
    public abstract void swim(int distance);
}

// Класс "Собака", наследуется от "Животное"
class Dog extends Animal {
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

// Класс "Кот", наследуется от "Животное"
class Cat extends Animal {
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

// Основной класс программы
public class Main {
    private static int animalCount = 0; // Счетчик всех животных

    public static void main(String[] args) {
        // Создаем животных
        Dog dog1 = new Dog("Корги");
        Dog dog2 = new Dog("Лабрадор");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");

        // Увеличиваем общий счетчик животных
        animalCount += Dog.getDogCount() + Cat.getCatCount();

        // Проверяем действия животных
        dog1.run(150); // Корги пробежал 150 м.
        dog1.swim(5);  // Корги проплыл 5 м.
        dog2.run(600); // Лабрадор не смог пробежать 600 м.
        dog2.swim(15); // Лабрадор не смог проплыть 15 м.

        cat1.run(100); // Барсик пробежал 100 м.
        cat1.swim(5);  // Барсик не умеет плавать.
        cat2.run(250); // Мурзик не смог пробежать 250 м.

        // Выводим статистику
        System.out.println("Всего животных: " + animalCount);
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}
