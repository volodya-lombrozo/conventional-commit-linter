package com.github.volodya_lombrozo.conventional_commit_linter.maven;

import org.apache.maven.shared.invoker.InvocationRequest;

public class Clean implements Command {
    private final String pom;
    private final String rawCommand;

    public Clean() {
        this("pom.xml");
    }

    public Clean(String pom) {
        this(pom, "clean");
    }

    public Clean(String pom, String rawCommand) {
        this.pom = pom;
        this.rawCommand = rawCommand;
    }

    @Override
    public InvocationRequest toRequest() {
        return new StringCommand(pom, rawCommand).toRequest();
    }
}
