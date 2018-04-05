package com.horsleyli.javalearning.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo1 {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(LoggerDemo1.class);
        logger.trace("trace level        trace：追踪，就是程序推进一下，可以写个trace输出");
        logger.debug("debug level        debug：调试，一般作为最低级别，trace基本不用");
        logger.info("info level        info：输出重要的信息，使用较多");
        logger.warn("warn level        warn：警告，有些信息不是错误信息，但也要给程序员一些提示");
        logger.error("error level        error：错误信息。用的也很多");
        logger.fatal("fatal level        fatal：致命错误。级别较高，这种级别不用调试了，重写吧……");

        for (int i = 0; i < Short.MAX_VALUE; i++) {
            logger.info("Hello World!");
        }
    }
}
