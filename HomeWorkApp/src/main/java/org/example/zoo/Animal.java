package org.example.zoo;

// Абстрактный класс "Животное"
public abstract class Animal {
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
