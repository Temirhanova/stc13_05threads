package ru.innopolis.stc13._13_Logging.Log4j;

import org.apache.log4j.Logger;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.error("debug-message");
        for (int i = 0; i < 10_000_000; i++) {
            LOGGER.info("messege");
        }
    }
}
