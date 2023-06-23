package org.example;


import org.junit.Test;
import java.util.logging.Logger;


public class SimpleMathLibraryTest  {
    private static Logger LOGGER = Logger.getLogger(SimpleMathLibrary.class.getName());
    private SimpleMathLibrary mathLibrary;

    public SimpleMathLibraryTest() {
        this.mathLibrary = new SimpleMathLibrary();
    }

    @Test
    public void testAdd() {
        double result = mathLibrary.add(2.5, 3.5);
        if (result == 6.0) {
            LOGGER.info("OK");
        } else {
            LOGGER.info("NOK");
        }
    }

    @Test
    public void testMinus() {
        double result = mathLibrary.minus(5.0, 2.0);
        if (result == 3.0) {
            LOGGER.info("OK");
        } else {
            LOGGER.info("NOK");
        }
    }
}
