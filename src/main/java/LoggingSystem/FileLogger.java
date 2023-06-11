package LoggingSystem;

import LoggingSystem.configuration.FileLoggerConfiguration;
import LoggingSystem.enums.LoggingLevel;

import LoggingSystem.interfaces.Printable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger implements Printable {

    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public boolean flag = false;

    public void info(String message) {
        writeInFile(message, LoggingLevel.INFO);
        flag = true;
    }


    public void debug(String message) {
        if (flag) {
            writeInFile(message, LoggingLevel.DEBUG);
        } else {
            throw new RuntimeException("DEBUG level started without INFO level");
        }

    }

    private void writeToFile(File file, String message, LoggingLevel level, DateFormat timestamp) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("[" + timestamp.format(new Date()) + "][" + level + "] " + "Message: " + message + "\n");
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInFile(String message, LoggingLevel level) {
        File file = new File(config.getFilename() + "." + config.getFormat());
        DateFormat timestamp = new SimpleDateFormat("dd-MM-yyy-HH-mm-ss");

        if (file.exists() && file.length() > config.getMaxSize()) {
            file = new File(file.getName() + "-" + timestamp.format(new Date()));
            writeToFile(file, message, level, timestamp);
        } else {
            writeToFile(file, message, level, timestamp);
        }
    }

}

