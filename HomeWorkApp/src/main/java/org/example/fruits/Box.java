package org.example.fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    // Метод для добавления фрукта в коробку
    public void add(T fruit) {
        fruits.add(fruit);
    }

    // Метод для получения веса коробки
    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    // Метод для сравнения веса коробок
    public boolean compare(Box<?> otherBox) {
        return Float.compare(this.getWeight(), otherBox.getWeight()) == 0;
    }

    // Метод для пересыпания фруктов в другую коробку
    public void transfer(Box<T> otherBox) {
        if (this == otherBox) {
            throw new IllegalArgumentException("Нельзя пересыпать фрукты в ту же коробку.");
        }

        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}

