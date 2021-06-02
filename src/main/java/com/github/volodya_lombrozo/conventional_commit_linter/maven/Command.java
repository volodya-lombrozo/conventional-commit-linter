package com.github.volodya_lombrozo.conventional_commit_linter.maven;

import org.apache.maven.shared.invoker.InvocationRequest;

public interface Command {
    InvocationRequest toRequest();
}