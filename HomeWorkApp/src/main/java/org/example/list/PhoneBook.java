package org.example.list;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Record> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    // Метод добавления записи
    public void add(Record record) {
        records.add(record);
    }

    // Метод поиска первой записи по имени
    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null; // Если запись не найдена
    }

    // Метод поиска всех записей по имени
    public List<Record> findAll(String name) {
        List<Record> result = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                result.add(record);
            }
        }
        return result; // Возвращаем пустой список, если ничего не найдено
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "records=" + records +
                '}';
    }
}
