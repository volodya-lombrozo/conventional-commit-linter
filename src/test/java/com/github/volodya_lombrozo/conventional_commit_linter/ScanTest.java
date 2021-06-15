package com.github.volodya_lombrozo.conventional_commit_linter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScanTest {

    @Test
    public void validator() {
        assertNotNull(Scan.ALL.validator());
        assertNotNull(Scan.LAST.validator());
        assertNotNull(Scan.NOTHING.validator());
    }
}