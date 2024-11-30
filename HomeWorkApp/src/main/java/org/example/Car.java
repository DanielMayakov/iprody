package org.example;

import lombok.Data;

@Data
public class Car {

    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("Car has started.");
    }

    private void startElectricity() {
        System.out.println("Electricity started.");
    }

    private void startCommand() {
        System.out.println("Command system started.");
    }

    private void startFuelSystem() {
        System.out.println("Fuel system started.");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}

