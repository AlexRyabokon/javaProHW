package coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "log4j2.xml");

        CoffeeOrderBoard ord = new CoffeeOrderBoard();
        LOGGER.info("Program works");


        try {
            ord.add(new Order("Anreew"));
            ord.add(new Order("Anreew11"));
            ord.add(new Order("Anreew22"));
            ord.add(new Order("Anreew33"));

            ord.add(new Order( "Keys"));

            LOGGER.info(ord.draw());
        } catch (RuntimeException e) {
            LOGGER.error("Exception: ", e);
        }
    }
}
