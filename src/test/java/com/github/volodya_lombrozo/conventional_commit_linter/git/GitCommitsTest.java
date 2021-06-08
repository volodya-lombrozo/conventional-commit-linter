package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Deque;

import static org.junit.Assert.*;

public class GitCommitsTest {

    private final String path = Path.of("src", "test", "resources",
            "git_repo_example.git")
            .toAbsolutePath().toString();

    @Test
    public void last() throws IOException {
        final GitCommits commits = new GitCommits(path);

        final Commit last = commits.last();

        assertEquals(new GitCommit("three"), last);
    }

    @Test
    public void toQueue() throws IOException {
        final GitCommits commits = new GitCommits(path);

        final Deque<Commit> queue = commits.toQueue();

        assertNotNull(queue);
        assertEquals(3, queue.size());
        assertEquals(new GitCommit("one"), queue.poll());
        assertEquals(new GitCommit("two"), queue.poll());
        assertEquals(new GitCommit("three"), queue.poll());
    }
}