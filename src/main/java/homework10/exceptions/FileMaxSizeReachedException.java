package homework10.exceptions;

import java.io.IOException;

public class FileMaxSizeReachedException extends RuntimeException{
    private String filename;
    private long maxSize;
    private long currentSize;

    public FileMaxSizeReachedException(String filename, long maxSize, long currentSize) {
        this.filename = filename;
        this.maxSize = maxSize;
        this.currentSize = currentSize;
    }

    public String getFilename() {
        return filename;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public long getCurrentSize() {
        return currentSize;
    }

    @Override
    public String getMessage() {
        return "File size limit reached. Maximum size: " + maxSize + ", Current size: " + currentSize + ", Filename: " + filename;
    }
}