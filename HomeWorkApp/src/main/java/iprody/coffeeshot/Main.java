package iprody.coffeeshot;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        // Добавляем заказы
        board.add("Alen");
        board.add("Yoda");
        board.add("Obi-van");
        board.add("John Snow");

        // Выводим текущее состояние очереди
        System.out.println("После добавления заказов:");
        board.draw();

        // Выдаем ближайший заказ
        System.out.println("Выдача ближайшего заказа: " + board.deliver());
        board.draw();

        // Выдаем заказ с определенным номером
        System.out.println("Выдача заказа с номером 33: " + board.deliver(33));
        board.draw();

        // Попытка выдать несуществующий заказ
        System.out.println("Выдача заказа с номером 100: " + board.deliver(100));
        board.draw();
    }
}

