package org.example.logger;

public class FileLoggerConfiguration implements LoggerConfiguration {
    private final String logFilePath;
    private final String logFileName;
    private final LoggingLevel loggingLevel;
    private final long maxFileSize;
    private final String pattern;

    public FileLoggerConfiguration(String logFilePath, String logFileName, LoggingLevel loggingLevel, long maxFileSize) {
        this.logFilePath = logFilePath;
        this.logFileName = logFileName;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.pattern = "[%s][%s] Сообщение: %s"; // Формат по умолчанию
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    @Override
    public LoggingLevel level() {
        return loggingLevel;
    }

    @Override
    public String pattern() {
        return pattern;
    }
}


