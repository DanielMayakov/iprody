package org.example.logger;

public enum LoggingLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5),
    FATAL(6);

    private final int priority;

    LoggingLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public boolean includes(LoggingLevel level) {
        return this.priority <= level.getPriority();
    }
}