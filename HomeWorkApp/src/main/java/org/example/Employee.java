package org.example;


public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee: " + fullName + ", Position: " + position + ", Email: " + email +
                ", Phone: " + phone + ", Age: " + age;
    }


    public static void main(String[] args) {
        Employee employee = new Employee("Иван Иванов", "Менеджер", "ivanov@example.com", "+123456789", 30);
        System.out.println(employee);
    }
}


