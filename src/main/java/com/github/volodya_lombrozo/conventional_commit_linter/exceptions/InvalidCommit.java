package com.github.volodya_lombrozo.conventional_commit_linter.exceptions;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;

import java.io.IOException;

public class InvalidCommit extends Exception {

    /**
     * @param commits - a collection of commits
     * @param format  - used format for validation of commits
     * @param ioe     - an internal exception happens during the reading of
     *                commits
     */
    public InvalidCommit(final Commits commits,
                         final Format format,
                         final IOException ioe) {
        super(String.format("Fail during validation of "
                + "Commits[%s] by the Format[%s]", commits, format), ioe);
    }

    /**
     * @param commit - a single commit
     * @param format - used format for validation of commits
     */
    public InvalidCommit(final Commit commit,
                         final Format format) {
        super(String.format("Commit %s not matches with the next format: %s. "
                + "Please, change the commit message.", commit, format));
    }

    /**
     * @param message - custom message
     */
    public InvalidCommit(final String message) {
        super(message);
    }
}
