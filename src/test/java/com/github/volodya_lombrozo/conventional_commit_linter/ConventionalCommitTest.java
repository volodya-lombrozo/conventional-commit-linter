package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.FakeCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.FreeFormat;
import com.github.volodya_lombrozo.conventional_commit_linter.format.WrongFormat;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConventionalCommitTest {

    @Test
    public void validateSuccessful() {
        try {
            final ConventionalCommit commit = new ConventionalCommit(new FakeCommit(), new FreeFormat());

            commit.validate();

        } catch (InvalidCommit invalidCommit) {
            fail();
        }
    }

    @Test(expected = InvalidCommit.class)
    public void validateFailed() throws InvalidCommit {
        final ConventionalCommit commit = new ConventionalCommit(new FakeCommit(), new WrongFormat());

        commit.validate();
    }
}