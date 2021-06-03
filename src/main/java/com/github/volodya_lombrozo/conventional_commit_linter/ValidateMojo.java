package com.github.volodya_lombrozo.conventional_commit_linter;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Mojo(name = "scan")
public class ValidateMojo extends AbstractMojo {

    @Parameter
    private boolean skip = true;


    @Override
    public void execute() {
        getLog().info("Validation Phase started");
        if (skip) {
            throw new IllegalStateException("Project not configured properly");
        } else {
            System.out.println("Plugin is passed");
        }
    }
}
