package org.example.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(String resourceName) throws IOException {
        Properties properties = new Properties();

        // Используем ClassLoader для загрузки файла из ресурсов
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IOException("Файл конфигурации не найден: " + resourceName);
            }
            properties.load(inputStream);
        }

        String filePath = properties.getProperty("filePath");
        String fileName = properties.getProperty("fileName");
        LoggingLevel level = LoggingLevel.valueOf(properties.getProperty("level").toUpperCase());
        long maxFileSize = Long.parseLong(properties.getProperty("maxFileSize"));
        String pattern = properties.getProperty("pattern");

        return new FileLoggerConfiguration(filePath, fileName, level, maxFileSize, pattern);
    }
}

