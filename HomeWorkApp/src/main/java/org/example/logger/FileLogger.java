package org.example.logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    @Override
    public void debug(String message) {
        log(LoggingLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    public void warn(String message) {
        log(LoggingLevel.WARN, message);
    }

    public void error(String message) {
        log(LoggingLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LoggingLevel.FATAL, message);
    }

    private synchronized void log(LoggingLevel level, String message) {
        // Проверяем, подходит ли уровень логирования
        if (!config.level().includes(level)) {
            return; // Уровень слишком низкий — игнорируем сообщение
        }

        try {
            // Форматируем сообщение
            String formattedMessage = formatMessage(level, message);
            byte[] messageBytes = formattedMessage.getBytes();

            // Получаем текущий файл для записи
            File currentLogFile = getCurrentLogFile();

            // Проверяем размер файла и создаем новый, если превышен лимит
            if (currentLogFile.exists() && Files.size(currentLogFile.toPath()) + messageBytes.length > config.getMaxFileSize()) {
                currentLogFile = createNewLogFile();
            }

            // Записываем сообщение в файл
            Files.write(currentLogFile.toPath(), messageBytes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getCurrentLogFile() throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm"));
        File logFile = new File(config.getLogFilePath(), config.getLogFileName() + "_" + timestamp + ".log");
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        return logFile;
    }

    private File createNewLogFile() throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss"));
        File newLogFile = new File(config.getLogFilePath(), config.getLogFileName() + "_" + timestamp + ".log");
        if (!newLogFile.exists()) {
            newLogFile.createNewFile();
        }
        return newLogFile;
    }

    private String formatMessage(LoggingLevel level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss"));
        return String.format(config.pattern(), timestamp, level, message) + System.lineSeparator();
    }
}


