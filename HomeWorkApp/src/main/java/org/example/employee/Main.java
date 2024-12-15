package org.example.employee;

public class Main {
    public static void main(String[] args) {
        // Создаем массив из 5 сотрудников
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иван Иванов", "Менеджер", "ivanov@mail.com", "+79991112233", 55000, 30);
        employees[1] = new Employee("Петр Петров", "Директор", "petrov@mail.com", "+79992223344", 150000, 45);
        employees[2] = new Employee("Сергей Сергеев", "Программист", "sergeev@mail.com", "+79993334455", 120000, 41);
        employees[3] = new Employee("Анна Антонова", "Бухгалтер", "antonova@mail.com", "+79994445566", 60000, 35);
        employees[4] = new Employee("Ольга Ольгина", "HR-менеджер", "olgina@mail.com", "+79995556677", 70000, 50);

        // Вывод информации о сотрудниках старше 40 лет
        System.out.println("Сотрудники старше 40 лет:");
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}
