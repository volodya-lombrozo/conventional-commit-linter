package com.github.volodya_lombrozo.conventional_commit_linter.log;

public class MojoLog implements Log {

    private final org.apache.maven.plugin.logging.Log mavenLog;

    public MojoLog(org.apache.maven.plugin.logging.Log mavenLog) {
        this.mavenLog = mavenLog;
    }

    @Override
    public void info(String message) {
        mavenLog.info(message);
    }

    @Override
    public void error(Exception e) {
        mavenLog.error(e);
    }
}
