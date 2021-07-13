package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.GitRepositoryException;
import com.github.volodya_lombrozo.conventional_commit_linter.util.StringInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GitProcess {

    /**
     * Java process builder for calling of OS.
     */
    private final ProcessBuilder processBuilder;


    /**
     * The constructor accepts a git directory path.
     * The next process builder will be created:
     * "git --git-dir=dir log --pretty=format:%s"
     *
     * @param dir - git directory (should be finished with .git folder).
     */
    public GitProcess(final String dir) {
        this(new ProcessBuilder("git",
                "--git-dir=" + dir,
                "log",
                "--pretty=format:%s")
        );
    }

    /**
     * The main constructor accepts any java process builder.
     *
     * @param builder - builder for Git log process.
     */
    public GitProcess(final ProcessBuilder builder) {
        this.processBuilder = builder;
    }

    /**
     * @return list of git messages
     * @throws GitRepositoryException if internal exception
     *                                occurred during execution of process.
     */
    public List<String> execute() throws GitRepositoryException {
        try {
            return tryToExecute();
        } catch (InterruptedException | IOException e) {
            throw new GitRepositoryException(e);
        }
    }

    private List<String> tryToExecute() throws IOException,
            InterruptedException {
        Process process = processBuilder.start();
        final int exitCode = process.waitFor();
        if (exitCode == 0) {
            return new StringInputStream(process.getInputStream()).lines();
        } else {
            InputStream error = process.getErrorStream();
            StringInputStream stringInputStream = new StringInputStream(error);
            throw new IOException(stringInputStream.toText());
        }
    }

}
