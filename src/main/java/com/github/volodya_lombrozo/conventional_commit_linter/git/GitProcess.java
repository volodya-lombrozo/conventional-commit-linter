package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.GitRepositoryException;
import com.github.volodya_lombrozo.conventional_commit_linter.util.StringInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GitProcess {

    private final ProcessBuilder processBuilder;

    public GitProcess(String dir) {
        this(new ProcessBuilder("git", "--git-dir=" + dir, "log", "--pretty=format:%s"));
    }

    public GitProcess(ProcessBuilder processBuilder) {
        this.processBuilder = processBuilder;
    }

    public List<String> execute() throws GitRepositoryException {
        try {
            return tryToExecute();
        } catch (InterruptedException | IOException e) {
            throw new GitRepositoryException(e);
        }
    }

    private List<String> tryToExecute() throws IOException, InterruptedException {
        Process process = processBuilder.start();
        final int exitCode = process.waitFor();
        if (exitCode == 0)  {
            return new StringInputStream(process.getInputStream()).lines();
        } else {
            InputStream errorStream = process.getErrorStream();
            StringInputStream stringInputStream = new StringInputStream(errorStream);
            throw new IOException(stringInputStream.toText());
        }
    }

}
