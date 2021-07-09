package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GitCommits implements Commits {

    private final ProcessBuilder processBuilder;

    public GitCommits() {
        this(".");
    }

    public GitCommits(String dir) {
        this(new ProcessBuilder("git", "--git-dir=" + dir, "log", "--pretty=format:%s"));
    }

    public GitCommits(ProcessBuilder processBuilder) {
        this.processBuilder = processBuilder;
    }


    @Override
    public Commit last() throws IOException {
        return toQueue().getLast();
    }

    @Override
    public Deque<Commit> toQueue() throws IOException {
        final List<String> messages = new GitProcess(processBuilder.start()).execute();
        final LinkedList<Commit> commits = messages.stream().map(GitCommit::new).collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(commits);
        return commits;
    }
}
