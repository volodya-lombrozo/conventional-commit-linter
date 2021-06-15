package com.github.volodya_lombrozo.conventional_commit_linter.validator;


import com.github.volodya_lombrozo.conventional_commit_linter.commit.FailCommits;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.FakeCommits;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.FreeFormat;
import org.junit.Test;

import static org.junit.Assert.fail;

public class AllCommitsValidatorTest {

    @Test
    public void validate() throws InvalidCommit {
        FakeCommits commits = new FakeCommits();
        FreeFormat format = new FreeFormat();

        AllCommitsValidator validator = new AllCommitsValidator(commits, format);

        validator.validate();
    }

    @Test(expected = InvalidCommit.class)
    public void validateException() throws InvalidCommit {
        FailCommits commits = new FailCommits();
        AllCommitsValidator validator=  new AllCommitsValidator(commits);

        validator.validate();

        fail();
    }
}