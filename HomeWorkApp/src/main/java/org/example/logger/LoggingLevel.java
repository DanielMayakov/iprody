package org.example.logger;

public enum LoggingLevel {
    INFO,
    DEBUG;

    public boolean includes(LoggingLevel level) {
        // INFO включает только INFO, DEBUG включает INFO и DEBUG
        return this == DEBUG || this == level;
    }
}

