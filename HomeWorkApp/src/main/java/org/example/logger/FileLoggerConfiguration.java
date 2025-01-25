package org.example.logger;

public record FileLoggerConfiguration(String filePath, String fileName, LoggingLevel level, long maxFileSize,
                                      String pattern) implements LoggerConfiguration {
    public static final String DEFAULT_PATTERN = "[%s][%s] Сообщение: %s";

    public FileLoggerConfiguration(String filePath, String fileName, LoggingLevel level, long maxFileSize, String pattern) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.level = level;
        this.maxFileSize = maxFileSize;
        this.pattern = pattern != null ? pattern : DEFAULT_PATTERN;
    }
}

