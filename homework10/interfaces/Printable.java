package homework10.interfaces;

import homework10.enums.LoggingLevel;
import homework10.exceptions.FileMaxSizeReachedException;

import java.io.File;
import java.io.IOException;

public interface Printable {

    void writeInFile(String message, LoggingLevel levels) throws IOException, FileMaxSizeReachedException;
}
