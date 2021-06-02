package com.github.volodya_lombrozo.conventional_commit_linter;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "scan")
public class ValidateMojo extends AbstractMojo {
    @Override
    public void execute() {
        System.out.println("Hello world");
    }
}
