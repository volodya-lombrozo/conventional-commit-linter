package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class GitCommits implements Commits {

    /**
     * Process for getting of commits from OS.
     */
    private final GitProcess process;

    /**
     * Default constructor.
     * Creates default Git process with the path = current_project_dir/.git.
     */
    public GitCommits() {
        this(System.getProperty("user.dir") + File.separator + ".git");
    }

    /**
     * Creates default Git process with the path = dir.
     * Warning: .git path should be defined as part of dir path.
     *
     * @param dir = .git folder path
     */
    public GitCommits(final String dir) {
        this(new GitProcess(dir));
    }

    /**
     * Constructor accepts any Git process for getting of Git commits.
     * Convenient for test purposes.
     *
     * @param gitProcess = any OS process (or the test one)
     *                   for getting of Git commits.
     */
    public GitCommits(final GitProcess gitProcess) {
        this.process = gitProcess;
    }


    @Override
    public Commit last() throws IOException {
        return toQueue().getLast();
    }

    @Override
    public Deque<Commit> toQueue() throws IOException {
        final List<String> messages = process.execute();
        final LinkedList<Commit> commits = messages.stream().map(GitCommit::new)
                .collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(commits);
        return commits;
    }

    @Override
    public String toString() {
        return "GitCommits";
    }
}
