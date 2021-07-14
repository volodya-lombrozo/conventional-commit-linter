package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;
import com.github.volodya_lombrozo.conventional_commit_linter.format.FreeFormat;
import com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;

import java.io.IOException;

public final class LastCommitValidator implements Validator {

    /**
     * Commits from an VCS.
     */
    private final Commits commits;

    /**
     * Allowed commit message format.
     */
    private final Format format;

    /**
     * Logging tool.
     */
    private final Log log;

    /**
     * @param verifiableCommits - commits from an VCS.
     */
    public LastCommitValidator(final Commits verifiableCommits) {
        this(verifiableCommits, new FreeFormat());
    }

    /**
     * @param verifiableCommits - commits from an VCS.
     * @param allowedFormat     - allowed commit message format.
     */
    public LastCommitValidator(final Commits verifiableCommits,
                               final Format allowedFormat) {
        this(verifiableCommits, allowedFormat, new JavaLog());
    }

    /**
     * @param verifiableCommits - commits from an VCS.
     * @param allowedFormat     - allowed commit message format.
     * @param logger            - logging tool.
     */
    public LastCommitValidator(final Commits verifiableCommits,
                               final Format allowedFormat,
                               final Log logger) {
        this.commits = verifiableCommits;
        this.format = allowedFormat;
        this.log = logger;
    }

    @Override
    public void validate() throws InvalidCommit {
        try {
            Commit commit = commits.last();
            final String logMessage = String.format("Validate last commit: "
                    + "%s by the format: %s", commit, this.format);
            log.info(logMessage);
            new CommitValidator(commit, this.format).validate();
        } catch (IOException ioe) {
            throw new InvalidCommit(commits, format, ioe);
        }
    }
}
