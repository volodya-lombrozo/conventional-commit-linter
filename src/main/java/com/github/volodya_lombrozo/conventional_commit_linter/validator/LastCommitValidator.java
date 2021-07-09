package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;
import com.github.volodya_lombrozo.conventional_commit_linter.format.FreeFormat;
import com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;

import java.io.IOException;

public class LastCommitValidator implements Validator {

    private final Commits commits;
    private final Format format;
    private final Log log;

    public LastCommitValidator(Commits commits, Format format) {
        this(commits, format, new JavaLog());
    }

    public LastCommitValidator(Commits commits, Format format, Log log) {
        this.commits = commits;
        this.format = format;
        this.log = log;
    }

    public LastCommitValidator(Commits commits) {
        this(commits, new FreeFormat());
    }

    @Override
    public void validate() throws InvalidCommit {
        try {
            Commit commit = commits.last();
            log.info(String.format("Validate last commit: %s by the format: %s", commit, format));
            new CommitValidator(commit, format).validate();
        } catch (IOException ioe) {
            throw new InvalidCommit(commits, format, ioe);
        }
    }
}
