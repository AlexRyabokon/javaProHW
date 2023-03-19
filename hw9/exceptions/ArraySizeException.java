package org.hillel.hw9.exceptions;

public class ArraySizeException extends IndexOutOfBoundsException {
    public ArraySizeException() {
    }

    public ArraySizeException(String s) {
        super(s);
    }
}
