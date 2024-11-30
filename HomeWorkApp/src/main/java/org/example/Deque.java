package org.example;

import java.util.Arrays;

class Deque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;

    public Deque(int capacity) {
        this.deque = new int[capacity];
        this.front = -1;
        this.rear = 0;
        this.size = 0;
    }

    // Добавление в голову очереди
    public void addFront(int value) {
        if (size >= deque.length) {
            throw new IllegalStateException("Очередь заполнена");
        }
        front = (front - 1 + deque.length) % deque.length;
        deque[front] = value;
        size++;
    }

    // Извлечение из головы очереди
    public int removeFront() {
        if (size == 0) {
            throw new IllegalStateException("Очередь пуста");
        }
        int value = deque[front];
        front = (front + 1) % deque.length;
        size--;
        return value;
    }

    // Добавление в хвост очереди
    public void addRear(int value) {
        if (size >= deque.length) {
            throw new IllegalStateException("Очередь заполнена");
        }
        rear = (rear + 1) % deque.length;
        deque[rear] = value;
        size++;
    }

    // Извлечение из хвоста очереди
    public int removeRear() {
        if (size == 0) {
            throw new IllegalStateException("Очередь пуста");
        }
        int value = deque[rear];
        rear = (rear - 1 + deque.length) % deque.length;
        size--;
        return value;
    }

    // Получение текущей длины очереди
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(deque, front, front + size));
    }

    // Пример использования
    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.addFront(10);
        deque.addRear(20);

        System.out.println("Двойная очередь: " + Arrays.toString(deque.deque));

        // deque.removeFront();
        //deque.removeFront();
    }
}


