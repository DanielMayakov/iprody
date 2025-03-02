package org.example.ThreadSafeList;

public class ThreadSafeListDemo {
    public static void main(String[] args) {
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();

        // Создаем потоки, работающие с коллекцией
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                threadSafeList.add(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                threadSafeList.remove(i);
            }
        };

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}

