package com.github.volodya_lombrozo.conventional_commit_linter.log;

public interface Log {
    void info(String message);

    void error(Exception e);
}
