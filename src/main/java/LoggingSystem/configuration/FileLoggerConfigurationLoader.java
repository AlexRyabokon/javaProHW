package LoggingSystem.configuration;


import LoggingSystem.enums.LoggingLevel;

import java.io.*;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(String file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            Properties props = new Properties();
            props.load(fis);
            return new FileLoggerConfiguration(props.getProperty("file"),
                    Enum.valueOf(LoggingLevel.class, props.getProperty("level")),
                    Long.parseLong(props.getProperty("size")),
                    props.getProperty("format"));

        } catch (RuntimeException | IOException e) {
          throw new RuntimeException();
        }

    }
}



