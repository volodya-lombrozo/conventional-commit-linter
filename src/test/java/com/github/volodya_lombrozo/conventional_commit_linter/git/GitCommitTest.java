package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.FakeCommit;
import org.junit.Test;

import static org.junit.Assert.*;

public class GitCommitTest {

    @Test
    public void message() {
        final String message = "message";
        final GitCommit commit = new GitCommit(message);

        final String actual = commit.message();

        assertEquals(message, actual);
    }

    @Test
    public void testToString() {
        final GitCommit commit = new GitCommit("message");

        final String actual = commit.toString();

        assertEquals("GitCommit[message='message']", actual);
    }

    @Test
    public void testEquals() {
        final GitCommit commit = new GitCommit("f");
        assertEquals(commit, commit);
        assertNotEquals(new GitCommit("m"), null);
        assertEquals(new GitCommit("m"), new GitCommit("m"));
        assertNotEquals(new GitCommit("m1"), new GitCommit("m2"));
    }

    @Test
    public void testHashCode() {
        final GitCommit first = new GitCommit("m1");
        final GitCommit second = new GitCommit("m2");
        assertNotEquals(0, first.hashCode());
        assertNotEquals(first.hashCode(), second.hashCode());
    }
}