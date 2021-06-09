package com.github.volodya_lombrozo.conventional_commit_linter.exceptions;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.FakeCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.FreeFormat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InvalidCommitTest {

    @Test
    public void exceptionMessageTest() {
        try {
            throw new InvalidCommit(new FakeCommit(), new FreeFormat());
        } catch (InvalidCommit invalidCommit) {
            assertNotNull(invalidCommit.getMessage());
        }
    }


}