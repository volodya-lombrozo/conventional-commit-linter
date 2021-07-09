package com.github.volodya_lombrozo.conventional_commit_linter.exceptions;

import java.io.IOException;
import java.util.List;

public class GitRepositoryException extends IOException {

    public GitRepositoryException(List<String> messages) {
        super(String.join("\n", messages));
    }

    public GitRepositoryException(Throwable cause) {
        super(cause);
    }
}
