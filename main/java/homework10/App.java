package homework10;

import homework10.configuration.FileLoggerConfiguration;
import homework10.configuration.FileLoggerConfigurationLoader;
import homework10.enums.LoggingLevel;
import homework10.exceptions.FileMaxSizeReachedException;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        FileLoggerConfiguration fileLoggerConfiguration =
                new FileLoggerConfiguration("src/main/resources/log.txt", LoggingLevel.INFO, 130, "txt");

        FileLoggerConfiguration fileLoggerConfigurationFromFile =
                FileLoggerConfigurationLoader.load("src/main/resources/options.properties");
        
        FileLogger fileLogger =
                new FileLogger(fileLoggerConfigurationFromFile);

        try {
            fileLogger.debug("Message");
        } catch (FileMaxSizeReachedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
