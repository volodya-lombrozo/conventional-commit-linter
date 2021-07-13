package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;

import java.util.Objects;

public final class GitCommit implements Commit {

    /**
     * Git commit message = git log --pretty=format:%s.
     */
    private final String message;

    /**
     * Main constructor accepts Git commit message as String.
     *
     * @param commitMessage - git commit message.
     */
    public GitCommit(final String commitMessage) {
        this.message = commitMessage;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("GitCommit[message='%s']", message);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GitCommit gitCommit = (GitCommit) o;
        return Objects.equals(message, gitCommit.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
