package homework10.configuration;

import homework10.enums.LoggingLevel;

import java.util.Objects;

public class FileLoggerConfiguration {
    private String filename;
    private LoggingLevel level;
    private long maxSize;
    private String format;

    public FileLoggerConfiguration(String filename, LoggingLevel level, long maxSize, String format) {
        this.filename = Objects.requireNonNull(filename, "Filename cannot be null");
        this.level = Objects.requireNonNull(level, "Logging level cannot be null");
        this.maxSize = Math.max(Objects.requireNonNull(maxSize, "Max size cannot be null"), 0);
        this.format = Objects.requireNonNull(format, "Log format cannot be null");
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
