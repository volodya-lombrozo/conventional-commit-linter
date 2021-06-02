package com.github.volodya_lombrozo.conventional_commit_linter.maven;

import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

public class Maven {

    private final Invoker invoker;
    private final MavenHome mavenHome;

    public Maven() {
        this(new DefaultInvoker());
    }

    public Maven(Invoker invoker) {
        this(invoker, new MavenHome());
    }

    public Maven(Invoker invoker, MavenHome mavenHome) {
        this.invoker = invoker;
        this.mavenHome = mavenHome;
    }

    public void execute(Command... commands) throws MavenInvocationException {
        invoker.setMavenHome(mavenHome.toFile());
        for (Command command : commands) {
            invoker.execute(command.toRequest());
        }
    }


}