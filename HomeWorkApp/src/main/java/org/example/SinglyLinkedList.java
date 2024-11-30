package org.example;

import java.util.Arrays;

class SinglyLinkedList {
    private int[] list;
    private int size;

    public SinglyLinkedList(int capacity) {
        this.list = new int[capacity];
        this.size = 0;
    }

    // Добавление в конец списка
    public void add(int value) {
        if (size >= list.length) {
            throw new IllegalStateException("Список заполнен");
        }
        list[size++] = value;
    }

    // Получение значения по индексу
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
        return list[index];
    }

    // Получение текущей длины списка
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(5);
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Список: " + list);
        System.out.println("Элемент по индексу 1: " + list.get(1));
        System.out.println("Текущая длина списка: " + list.getSize());
    }
}

