package iprody.coffeeshot;

import java.util.*;

public class CoffeeOrderBoard {
    private final List<Order> orders; // Список текущих заказов
    private int nextOrderNumber = 1; // Следующий номер заказа

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
    }

    // Метод добавления нового заказа
    public void add(String name) {
        Order newOrder = new Order(nextOrderNumber++, name);
        orders.add(newOrder);
    }

    // Метод выдачи ближайшего заказа (первый в очереди)
    public Order deliver() {
        if (orders.isEmpty()) {
            System.out.println("Очередь пуста!");
            return null;
        }
        return orders.remove(0); // Удаляем первый заказ из списка
    }

    // Метод выдачи заказа по номеру
    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getNumber() == orderNumber) {
                orders.remove(order); // Удаляем заказ из списка
                return order;
            }
        }
        System.out.println("Заказ с номером " + orderNumber + " не найден!");
        return null;
    }

    // Метод отображения текущей очереди заказов
    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order); // Используем toString из класса Order
        }
        System.out.println("=============");
    }
}

