package org.example.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(String fileName) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(fileName)) {
            properties.load(input);
        }

        String logFilePath = properties.getProperty("logFilePath");
        String logFileName = properties.getProperty("logFileName");
        LoggingLevel loggingLevel = LoggingLevel.valueOf(properties.getProperty("loggingLevel"));
        long maxFileSize = Long.parseLong(properties.getProperty("maxFileSize"));

        return new FileLoggerConfiguration(logFilePath, logFileName, loggingLevel, maxFileSize);
    }
}