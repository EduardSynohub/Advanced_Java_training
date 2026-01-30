package pl.eduard.training.maven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLog {
    private static final Logger log = LogManager.getLogger(MainLog.class);
    public static void main(String[] args) {
        log.debug("Debug");
        log.info("Info");
        log.error("Error");
        log.warn("Warn");
        log.fatal("Fatal");
        log.info("string: {}.", "Hello world");
    }
}
