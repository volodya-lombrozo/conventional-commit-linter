package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;
import com.github.volodya_lombrozo.conventional_commit_linter.format.FreeFormat;

import java.io.IOException;

public class LastCommitValidator implements Validator{

    private final Commits commits;
    private final Format format;

    public LastCommitValidator(Commits commits, Format format) {
        this.commits = commits;
        this.format = format;
    }

    public LastCommitValidator(Commits commits) {
        this(commits, new FreeFormat());
    }

    @Override
    public void validate() throws InvalidCommit {
        try {
            Commit commit = commits.last();
            new CommitValidator(commit, format).validate();
        } catch (IOException ioe) {
            throw new InvalidCommit(commits, format, ioe);
        }
    }
}
