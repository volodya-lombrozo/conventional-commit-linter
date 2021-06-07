package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;

import java.util.Objects;
import java.util.StringJoiner;

public class GitCommit implements Commit {
    private final String message;

    public GitCommit(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GitCommit.class.getSimpleName() + "[", "]")
                .add("message='" + message + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitCommit gitCommit = (GitCommit) o;
        return Objects.equals(message, gitCommit.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
