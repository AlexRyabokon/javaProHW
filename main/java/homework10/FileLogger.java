package homework10;

import homework10.configuration.FileLoggerConfiguration;
import homework10.enums.LoggingLevel;
import homework10.exceptions.FileMaxSizeReachedException;
import homework10.interfaces.Printable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class FileLogger implements Printable {

    private final FileLoggerConfiguration config;
    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }



    public void info(String message) throws FileMaxSizeReachedException, IOException {
        writeInFile(message, LoggingLevel.INFO);
    }


    public void debug(String message) throws FileMaxSizeReachedException, IOException {
        writeInFile(message, LoggingLevel.DEBUG);
    }


    @Override
    public void readInFile(File file) {

    }

    @Override
    public void writeInFile(String message, LoggingLevel... levels) throws FileMaxSizeReachedException, IOException {
        File file = new File(config.getFilename());
        Date timestamp = new Date();

        if (file.exists() && file.length() >= config.getMaxSize()) {
            createNewLogFile(file.getName()+" # ");
            throw  new FileMaxSizeReachedException(config.getFilename(), config.getMaxSize(), file.length());
        } else{
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("[" + timestamp + "][" + Arrays.toString(levels) + "] " + "Message: " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }}
    }
    private void createNewLogFile(String fileName ) throws IOException {
        String newFileName = fileName;
        File newLogFile = new File(newFileName);
        newLogFile.createNewFile();
    }
}

