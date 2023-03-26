package homework10.configuration;


import homework10.enums.LoggingLevel;

import java.io.*;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    public static LoggingLevel choice(String str) throws IllegalAccessException {
        String value = str.toUpperCase();

        if (value.equals("INFO")){
            return LoggingLevel.INFO;
        } else if (value.equals("DEBUG")) {
            return LoggingLevel.DEBUG;
        } else{
            throw new IllegalAccessException("Set value only INFO or DEBUG in key 'level'");
        }

    }
    
    public static FileLoggerConfiguration load(String file) throws IOException, IllegalAccessException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(file);
        props.load(fis);

        FileLoggerConfiguration fileLoggerConfiguration =
                new FileLoggerConfiguration(props.getProperty("file"),
                        choice(props.getProperty("level")),
                        Long.parseLong(props.getProperty("size")),
                        props.getProperty("format"));

        fis.close();

        return fileLoggerConfiguration;
    }
}
