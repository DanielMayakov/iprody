package org.example.zoo;

// Основной класс программы
public class Main {
    private static int animalCount = 0; // Счетчик всех животных

    public static void main(String[] args) {
        // Создаем животных
        Dog korgi = new Dog("Корги");
        Dog labrador = new Dog("Лабрадор");
        Cat barsik = new Cat("Барсик");
        Cat murzik= new Cat("Мурзик");

        // Увеличиваем общий счетчик животных
        animalCount += Dog.getDogCount() + Cat.getCatCount();

        // Проверяем действия животных
        korgi.run(150); // Корги пробежал 150 м.
        korgi.swim(5);  // Корги проплыл 5 м.
        labrador.run(600); // Лабрадор не смог пробежать 600 м.
        labrador.swim(15); // Лабрадор не смог проплыть 15 м.

        barsik.run(100); // Барсик пробежал 100 м.
        barsik.swim(5);  // Барсик не умеет плавать.
        murzik.run(250); // Мурзик не смог пробежать 250 м.

        // Выводим статистику
        System.out.println("Всего животных: " + animalCount);
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}
