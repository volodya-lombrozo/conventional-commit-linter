package com.github.volodya_lombrozo.conventional_commit_linter.commit;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public final class FakeCommits implements Commits {

    /**
     * Collection of commits in memory.
     */
    private final Deque<Commit> commits;

    /**
     * Default constructor with several fake commits.
     */
    public FakeCommits() {
        this(new FakeCommit(), new FakeCommit(), new FakeCommit());
    }

    /**
     * Convenient constructor for different number of commits.
     *
     * @param commitsArray - array of commits
     */
    public FakeCommits(final Commit... commitsArray) {
        this(new LinkedList<>(Arrays.asList(commitsArray)));
    }

    /**
     * Main constructor.
     *
     * @param commitsQueue - collection of commits.
     *                     All commits are copied for security purposes.
     */
    public FakeCommits(final Deque<Commit> commitsQueue) {
        this.commits = new ArrayDeque<>(commitsQueue);
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
