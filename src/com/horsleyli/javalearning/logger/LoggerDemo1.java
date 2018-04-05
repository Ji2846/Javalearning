package com.horsleyli.javalearning.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo1 {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(LoggerDemo1.class);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.error("error level");
        logger.fatal("fatal level");
    }
}
