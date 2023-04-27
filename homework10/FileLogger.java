package homework10;

import homework10.configuration.FileLoggerConfiguration;
import homework10.enums.LoggingLevel;
import homework10.exceptions.FileMaxSizeReachedException;
import homework10.interfaces.Printable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class FileLogger implements Printable {

    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }


    public void info(String message){
        writeInFile(message, LoggingLevel.INFO);
    }


    public void debug(String message){
        writeInFile(message, LoggingLevel.DEBUG);
    }

    @Override
    public void writeInFile(String message, LoggingLevel levels) {
        File file = new File(config.getFilename());
        Date timestamp = new Date();

        if (file.exists() && file.length() > config.getMaxSize()) {
            file = new File( file.getName() + "#" + timestamp.getTime());
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("[" + timestamp + "][" + levels + "] " + "Message: " + message + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("[" + timestamp + "][" + levels + "] " + "Message: " + message + "\n");
            } catch (RuntimeException | IOException e) {
                e.printStackTrace();
            }
        }
    }


}

