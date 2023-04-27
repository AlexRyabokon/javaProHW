package homework10;

import homework10.configuration.FileLoggerConfiguration;
import homework10.configuration.FileLoggerConfigurationLoader;
import homework10.enums.LoggingLevel;
import homework10.exceptions.FileMaxSizeReachedException;

import java.io.IOException;

public class App {
    public static void main(String[] args){
        FileLoggerConfiguration fileLoggerConfiguration =
                new FileLoggerConfiguration("src/main/resources/log.txt", LoggingLevel.INFO, 130, "txt");

        FileLoggerConfiguration fileLoggerConfigurationFromFile =
                FileLoggerConfigurationLoader.load("src/main/resources/logger-cfg.properties");

        FileLogger fileLogger =
                new FileLogger(fileLoggerConfigurationFromFile);


        fileLogger.debug("Message");
    }


}
