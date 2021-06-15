package com.github.volodya_lombrozo.conventional_commit_linter.commit;

import java.io.IOException;
import java.util.Deque;

public class FailCommits implements Commits{
    @Override
    public Commit last() throws IOException {
        throw new IOException("Mock fail during getting of the last commit");
    }

    @Override
    public Deque<Commit> toQueue() throws IOException {
        throw new IOException("Mock fail during getting of all commits");
    }
}
