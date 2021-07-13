package com.github.volodya_lombrozo.conventional_commit_linter.format;

public interface Format {

    /**
     * Regexp:
     * https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html.
     *
     * @return free format regexp string
     */
    String regexp();

}
