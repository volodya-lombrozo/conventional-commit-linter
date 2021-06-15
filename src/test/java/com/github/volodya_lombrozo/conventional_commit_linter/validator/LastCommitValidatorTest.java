package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.FailCommits;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.FakeCommits;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import org.junit.Test;

import static org.junit.Assert.fail;

public class LastCommitValidatorTest {

    @Test
    public void validate() throws InvalidCommit {
        LastCommitValidator validator = new LastCommitValidator(new FakeCommits());

        validator.validate();
    }

    @Test(expected = InvalidCommit.class)
    public void validateException() throws InvalidCommit {
        LastCommitValidator validator = new LastCommitValidator(new FailCommits());

        validator.validate();

        fail();
    }
}