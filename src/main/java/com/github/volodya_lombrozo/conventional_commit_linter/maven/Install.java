package com.github.volodya_lombrozo.conventional_commit_linter.maven;

import org.apache.maven.shared.invoker.InvocationRequest;

public class Install implements Command {

    private final String pom;
    private final String rawCommand;

    public Install() {
        this("pom.xml");
    }

    public Install(String pom) {
        this(pom, "install -DskipTests");
    }

    public Install(String pom, String rawCommand) {
        this.pom = pom;
        this.rawCommand = rawCommand;
    }

    @Override
    public InvocationRequest toRequest() {
        return new StringCommand(pom, rawCommand).toRequest();
    }
}
