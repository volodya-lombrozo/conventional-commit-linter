package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.GitRepositoryException;
import com.github.volodya_lombrozo.conventional_commit_linter.util.StringInputStream;

import java.io.IOException;
import java.util.List;

public class GitProcess {

    private final Process process;

    public GitProcess(Process process) {
        this.process = process;
    }

    public List<String> execute() throws GitRepositoryException {
        try {
            final int exitCode = process.waitFor();
            if (exitCode == 0) {
                return new StringInputStream(process.getInputStream()).lines();
            } else {
                throw new GitRepositoryException(new StringInputStream(process.getErrorStream()).lines());
            }
        } catch (InterruptedException | IOException e) {
            throw new GitRepositoryException(e);
        }
    }

}
