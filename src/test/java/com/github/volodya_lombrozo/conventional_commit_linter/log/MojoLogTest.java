package com.github.volodya_lombrozo.conventional_commit_linter.log;

import org.apache.maven.plugin.logging.Log;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MojoLogTest {

    public Log mavenLog = Mockito.mock(Log.class);

    @Test
    public void info() {
        final MojoLog log = new MojoLog(mavenLog);
        final String message = "Message";

        log.info(message);

        verify(mavenLog, times(1)).info(message);
    }

    @Test
    public void error() {
        final MojoLog log = new MojoLog(mavenLog);
        final Exception e = new Exception("some exception");

        log.error(e);

        verify(mavenLog, times(1)).error(e);
    }
}