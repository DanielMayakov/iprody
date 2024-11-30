package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int age;

    public static void main(String[] args) {

        Employee employee = new Employee("Иван Иванов", "Менеджер", "ivanov@example.com", "+123456789", 30);

        System.out.println(employee);

        employee.setAge(35);
        System.out.println("Updated age: " + employee.getAge());
    }
}

