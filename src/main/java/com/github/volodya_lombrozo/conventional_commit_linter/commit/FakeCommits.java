package com.github.volodya_lombrozo.conventional_commit_linter.commit;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public final class FakeCommits implements Commits {

    private final Deque<Commit> commits;

    public FakeCommits() {
        this(new FakeCommit(), new FakeCommit(), new FakeCommit());
    }

    public FakeCommits(final Commit... commitsArray) {
        this(new LinkedList<>(Arrays.asList(commitsArray)));
    }

    public FakeCommits(final Deque<Commit> commitsQueue) {
        this.commits = commitsQueue;
    }

    @Override
    public Commit last() {
        return new FakeCommit();
    }

    @Override
    public Deque<Commit> toQueue() {
        return commits;
    }
}
