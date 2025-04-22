package org.example.ThreadSafeList;

public class PetrolStationDemo {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(100); // Инициализируем станцию с 100 литрами топлива

        // Создаем потоки для заправки
        Runnable carTask = () -> petrolStation.doTank(20);

        Thread car1 = new Thread(carTask, "Car-1");
        Thread car2 = new Thread(carTask, "Car-2");
        Thread car3 = new Thread(carTask, "Car-3");
        Thread car4 = new Thread(carTask, "Car-4");
        Thread car5 = new Thread(carTask, "Car-5");

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
    }
}
