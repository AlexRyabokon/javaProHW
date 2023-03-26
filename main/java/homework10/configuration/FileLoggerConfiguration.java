package homework10.configuration;

import homework10.enums.LoggingLevel;

public class FileLoggerConfiguration {
    private String filename;
    private LoggingLevel level;
    private long maxSize;
    private String format;

    public FileLoggerConfiguration(String filename, LoggingLevel level, long maxSize, String format) {
        this.filename = filename;
        this.level = level;
        this.maxSize = maxSize;
        this.format = format;
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
