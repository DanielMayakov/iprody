package org.example.ThreadSafeList;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<T> {
    private final List<T> list = new ArrayList<>(); // Основная коллекция

    // Метод для добавления элемента
    public List<T> getList() {
        lock.lock();
        try {
            return new ArrayList<>(list); // Возвращаем копию списка для безопасности
        } finally {
            lock.unlock();
        }
    }
    // Метод для удаления элемента
    public synchronized void remove(T element) {
        if (list.remove(element)) {
            System.out.println(Thread.currentThread().getName() + " removed: " + element);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to remove: " + element);
        }
    }

    // Метод для получения элемента по индексу
    public synchronized T get(int index) {
        if (index >= 0 && index < list.size()) {
            T element = list.get(index);
            System.out.println(Thread.currentThread().getName() + " retrieved: " + element);
            return element;
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to access invalid index: " + index);
            return null;
        }
    }

    // Метод для получения размера списка
    public synchronized int size() {
        return list.size();
    }
}

