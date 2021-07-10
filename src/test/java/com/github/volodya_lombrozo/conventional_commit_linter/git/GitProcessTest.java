package com.github.volodya_lombrozo.conventional_commit_linter.git;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.GitRepositoryException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;

public class GitProcessTest {


    @Test(expected = IOException.class)
    public void failedGitProcess() throws GitRepositoryException {
        ProcessBuilder processBuilder = new ProcessBuilder("false");
        GitProcess gitProcess = new GitProcess(processBuilder);

        gitProcess.execute();

        fail();
    }

}