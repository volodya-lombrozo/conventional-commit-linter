package com.github.volodya_lombrozo.conventional_commit_linter.log;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class JavaLogTest {

    @Test
    public void info() {
        final Logger mock = Mockito.mock(Logger.class);
        final JavaLog log = new JavaLog(mock);
        final String message = "message";

        log.info(message);

        verify(mock, times(1)).info(message);
    }

    @Test
    public void error() {
        final Logger mock = Mockito.mock(Logger.class);
        final JavaLog log = new JavaLog(mock);
        final String message = "Message";

        log.error(new Exception(message));

        verify(mock, times(1)).info(message);
    }
}