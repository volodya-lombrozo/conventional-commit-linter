package com.github.volodya_lombrozo.conventional_commit_linter.log;

public interface Log {

    /**
     * Prints message. INFO level is used.
     *
     * @param message - simple logged message.
     */
    void info(String message);


    /**
     * Prints exception to log. ERROR level is used.
     *
     * @param e - any exception
     */
    void error(Exception e);
}
