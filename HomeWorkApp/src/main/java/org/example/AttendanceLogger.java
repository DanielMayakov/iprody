package org.example;

import java.util.*;

public class AttendanceLogger {

    // Журнал посещений
    private final List<VisitRecord> visitLog;

    // Конструктор
    public AttendanceLogger() {
        this.visitLog = new ArrayList<>();
    }

    // Метод для регистрации нового посещения
    public void registerVisit(String userId, String timestamp) {
        visitLog.add(new VisitRecord(userId, timestamp));
    }

    // Метод для вычисления частоты посещений для каждого уникального сотрудника
    public Map<String, Integer> calculateVisitFrequency() {
        Map<String, Integer> visitFrequency = new HashMap<>();
        for (VisitRecord record : visitLog) {
            visitFrequency.put(record.getUserId(), visitFrequency.getOrDefault(record.getUserId(), 0) + 1);
        }
        return visitFrequency;
    }

    // Метод для вычисления самого популярного времени (часа) посещения офиса
    public String calculateMostPopularHour() {
        Map<String, Integer> hourFrequency = new HashMap<>();

        // Подсчет количества посещений для каждого часа
        for (VisitRecord record : visitLog) {
            String hour = record.getTimestamp().substring(0, 2) + ":00"; // Извлекаем только час
            hourFrequency.put(hour, hourFrequency.getOrDefault(hour, 0) + 1);
        }

        // Находим час с максимальным количеством посещений
        return hourFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No visits");
    }

    // Вспомогательный класс для записи посещений
    private static class VisitRecord {
        private final String userId;
        private final String timestamp;

        public VisitRecord(String userId, String timestamp) {
            this.userId = userId;
            this.timestamp = timestamp;
        }

        public String getUserId() {
            return userId;
        }

        public String getTimestamp() {
            return timestamp;
        }
    }

    // Тестирование программы
    public static void main(String[] args) {
        AttendanceLogger logger = getAttendanceLogger();

        // Вычисление частоты посещений
        Map<String, Integer> visitFrequency = logger.calculateVisitFrequency();
        System.out.println("Частота посещений:");
        for (Map.Entry<String, Integer> entry : visitFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Вычисление самого популярного часа
        String mostPopularHour = logger.calculateMostPopularHour();
        System.out.println("\nСамое популярное время посещений: " + mostPopularHour);
    }

    private static AttendanceLogger getAttendanceLogger() {
        AttendanceLogger logger = new AttendanceLogger();

        // Пример журнала посещений
        logger.registerVisit("user1", "09:15");
        logger.registerVisit("user2", "10:00");
        logger.registerVisit("user1", "09:45");
        logger.registerVisit("user3", "11:30");
        logger.registerVisit("user2", "10:20");
        logger.registerVisit("user4", "14:10");
        logger.registerVisit("user1", "09:55");
        logger.registerVisit("user2", "10:45");
        logger.registerVisit("user4", "14:25");
        logger.registerVisit("user3", "11:50");
        logger.registerVisit("user5", "15:00");
        logger.registerVisit("user1", "16:30");
        logger.registerVisit("user3", "11:59");
        return logger;
    }
}
