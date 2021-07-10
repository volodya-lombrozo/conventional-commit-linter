package com.github.volodya_lombrozo.conventional_commit_linter.exceptions;

import java.io.IOException;

public class GitRepositoryException extends IOException {

    public GitRepositoryException(Throwable cause) {
        super(cause);
    }
}
