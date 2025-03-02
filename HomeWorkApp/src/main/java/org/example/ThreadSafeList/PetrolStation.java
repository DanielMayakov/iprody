package org.example.ThreadSafeList;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class PetrolStation {
    private double fuelAmount; // Количество топлива на станции
    private final Semaphore semaphore; // Семафор для ограничения количества клиентов

    public PetrolStation(double initialFuelAmount) {
        this.fuelAmount = initialFuelAmount;
        this.semaphore = new Semaphore(3); // Разрешить максимум 3 одновременных заправки
    }

    // Метод для заправки
    public void doTank(double amount) {
        try {
            semaphore.acquire(); // Захватываем семафор
            synchronized (this) { // Синхронизируем доступ к топливу
                if (fuelAmount >= amount) {
                    System.out.println(Thread.currentThread().getName() + " is refueling " + amount + " liters...");
                    fuelAmount -= amount;
                    System.out.println(Thread.currentThread().getName() + " finished refueling. Remaining fuel: " + fuelAmount + " liters.");
                } else {
                    System.out.println(Thread.currentThread().getName() + " tried to refuel " + amount + " liters, but not enough fuel is available.");
                }
            }
            // Симулируем время заправки от 3 до 10 секунд
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 10000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(Thread.currentThread().getName() + " was interrupted.");
        } finally {
            semaphore.release(); // Освобождаем семафор
        }
    }
}
