package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import LoggingSystem.FileLogger;
import LoggingSystem.configuration.FileLoggerConfiguration;
import LoggingSystem.enums.LoggingLevel;



public class AppTest 
{

    @Test
    void info_ShouldWriteToFileWithINFOLevel() {
        FileLoggerConfiguration config = new FileLoggerConfiguration("log", LoggingLevel.INFO, 1024, "txt" );
        FileLogger logger = new FileLogger(config);
        String message = "This is an INFO message";

        logger.info(message);
    }

    @Test
    void debug_WithoutInfo_ShouldThrowRuntimeException() {
        FileLoggerConfiguration config = new FileLoggerConfiguration("log", LoggingLevel.DEBUG, 1024, "txt" );
        FileLogger logger = new FileLogger(config);
        String message = "This is a DEBUG message";

        assertThrows(RuntimeException.class, () -> {
            logger.debug(message);
        });
    }

}
