package com.github.volodya_lombrozo.conventional_commit_linter.commit;

public class FakeCommit implements Commit {
    @Override
    public String message() {
        return "fake commit message";
    }

    @Override
    public String toString() {
        return String.format("FakeCommit[%s]", message());
    }
}
