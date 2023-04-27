package homework10.configuration;


import homework10.enums.LoggingLevel;

import java.io.*;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String file) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(file)) {
            props.load(fis);

            FileLoggerConfiguration fileLoggerConfiguration =
                    new FileLoggerConfiguration(props.getProperty("file"),
                            Enum.valueOf(LoggingLevel.class, props.getProperty("level")),
                            Long.parseLong(props.getProperty("size")),
                            props.getProperty("format"));

            return fileLoggerConfiguration;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}



