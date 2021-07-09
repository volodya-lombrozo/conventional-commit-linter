package com.github.volodya_lombrozo.conventional_commit_linter.log;

import java.util.logging.Logger;

public class JavaLog implements Log {

    private final Logger logger;

    public JavaLog() {
        this(Logger.getLogger(JavaLog.class.getName()));
    }

    public JavaLog(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void error(Exception e) {
        logger.info(e.getMessage());
    }
}
