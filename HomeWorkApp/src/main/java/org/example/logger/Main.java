package org.example.logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        // Загружаем конфигурацию
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = loader.load("logger.properties");

        // Создаем логгер
        FileLogger logger = new FileLogger(config);

        // Логируем сообщения
        logger.info("Hello, world!");
        logger.debug("Your IP-Address: 127.0.0.1");
        logger.info("This is an info message.");
        logger.debug("Debugging application...");
    }
}

