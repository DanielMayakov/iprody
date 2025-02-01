package iprody.coffeeshot;

public class Order {
    private final int number; // Номер заказа
    private final String name; // Имя заказчика

    public Order(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return number + " | " + name;
    }
}
