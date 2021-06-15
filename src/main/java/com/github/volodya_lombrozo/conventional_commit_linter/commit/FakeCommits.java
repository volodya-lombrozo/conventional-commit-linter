package com.github.volodya_lombrozo.conventional_commit_linter.commit;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FakeCommits implements Commits{

    private final Deque<Commit> commits;

    public FakeCommits() {
        this(new FakeCommit(), new FakeCommit(), new FakeCommit());
    }

    public FakeCommits(Commit... commits){
        this(new LinkedList<>(Arrays.asList(commits)));
    }

    public FakeCommits(Deque<Commit> commits) {
        this.commits = commits;
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
