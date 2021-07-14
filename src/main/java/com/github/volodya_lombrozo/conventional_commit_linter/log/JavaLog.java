package com.github.volodya_lombrozo.conventional_commit_linter.log;

import java.util.logging.Logger;

public final class JavaLog implements Log {

    /**
     * Standard java logger. Delegate object.
     */
    private final Logger logger;

    /**
     * Default constructor creates default java logger with name:
     * com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog.
     */
    public JavaLog() {
        this(Logger.getLogger(JavaLog.class.getName()));
    }

    /**
     * @param log - standard java logger.
     */
    public JavaLog(final Logger log) {
        this.logger = log;
    }

    @Override
    public void info(final String message) {
        logger.info(message);
    }

    @Override
    public void error(final Exception e) {
        logger.info(e.getMessage());
    }
}
