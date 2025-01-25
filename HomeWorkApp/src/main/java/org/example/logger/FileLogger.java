package org.example.logger;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private final FileLoggerConfiguration config;
    private File currentLogFile;

    public FileLogger(FileLoggerConfiguration config) {
        if (config == null) {
            throw new IllegalArgumentException("Config cannot be null");
        }
        this.config = config;

        // Дополнительная логика, например, проверка файловой системы
        File logFile = new File(config.filePath(), config.fileName());
        if (!logFile.exists()) {
            try {
                logFile.createNewFile(); // Создаём файл, если он отсутствует
            } catch (IOException e) {
                throw new RuntimeException("Не удалось создать файл лога: " + logFile.getAbsolutePath(), e);
            }
        }
    }

    private void createNewLogFile() throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm"));
        String newFileName = config.fileName().replace(".log", "_" + timestamp + ".log");
        currentLogFile = new File(config.filePath(), newFileName);
        if (!currentLogFile.exists()) {
            currentLogFile.createNewFile();
        }
    }

    private void log(LoggingLevel level, String message) throws IOException {
        if (!config.level().includes(level)) {
            return; // Уровень логирования ниже текущего уровня конфигурации
        }

        String formattedMessage = String.format(config.pattern(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss")),
                level.name(),
                message);

        // Проверяем размер файла
        if (currentLogFile.length() + formattedMessage.getBytes().length > config.maxFileSize()) {
            createNewLogFile();
        }

        // Записываем в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentLogFile, true))) {
            writer.write(formattedMessage);
            writer.newLine();
        }
    }

    @Override
    public void debug(String message) {
        try {
            log(LoggingLevel.DEBUG, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void info(String message) {
        try {
            log(LoggingLevel.INFO, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

