package LoggingSystem.interfaces;

import LoggingSystem.enums.LoggingLevel;

public interface Printable {

    void writeInFile(String message, LoggingLevel levels);
}
