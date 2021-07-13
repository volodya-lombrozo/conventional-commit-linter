package com.github.volodya_lombrozo.conventional_commit_linter.exceptions;

import java.io.IOException;

public class GitRepositoryException extends IOException {

    /**
     * @param cause - any caused exception during the reading
     *              of commits from OS
     */
    public GitRepositoryException(final Exception cause) {
        super(cause);
    }
}
