package com.github.volodya_lombrozo.conventional_commit_linter.maven;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.InvocationRequest;

import java.nio.file.Path;
import java.util.Arrays;

public class StringCommand implements Command {

    private final String pom;
    private final String[] command;

    public StringCommand(String pom, String... command) {
        this.pom = pom;
        this.command = command;
    }

    @Override
    public InvocationRequest toRequest() {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(Path.of(pom).toFile());
        request.setGoals(Arrays.asList(command));
        return request;
    }
}
