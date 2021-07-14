package com.github.volodya_lombrozo.conventional_commit_linter.log;

/**
 * Maven implementation of the logger.
 */
public final class MojoLog implements Log {

    /**
     * Maven MoJo logger.
     */
    private final org.apache.maven.plugin.logging.Log mavenLog;

    /**
     * @param log - a maven MoJo logger
     */
    public MojoLog(final org.apache.maven.plugin.logging.Log log) {
        this.mavenLog = log;
    }

    @Override
    public void info(final String message) {
        mavenLog.info(message);
    }

    @Override
    public void error(final Exception e) {
        mavenLog.error(e);
    }
}
