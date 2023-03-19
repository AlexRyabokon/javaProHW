package org.hillel.hw9.exceptions;

public class ArrayDataException extends RuntimeException {
    public ArrayDataException() {
    }

    public ArrayDataException(String message) {
        super(message);
    }

    public ArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
