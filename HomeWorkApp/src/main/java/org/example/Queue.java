package org.example;

import java.util.Arrays;

class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Добавление в очередь
    public void enqueue(int value) {
        if (size >= queue.length) {
            throw new IllegalStateException("Очередь заполнена");
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    // Извлечение из очереди (FIFO)
    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Очередь пуста");
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    // Получение текущей длины очереди
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(queue, front, front + size));
    }

    // Пример использования
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Очередь: " + queue);
        System.out.println("Извлечено из очереди: " + queue.dequeue());
        System.out.println("Очередь после извлечения: " + queue);
    }


}

