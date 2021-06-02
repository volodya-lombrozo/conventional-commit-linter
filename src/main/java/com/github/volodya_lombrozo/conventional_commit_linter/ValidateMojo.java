package com.github.volodya_lombrozo.conventional_commit_linter;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.nio.file.Path;

@Mojo(name = "scan")
public class ValidateMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Override
    public void execute() {
        getLog().info("Validation Phase started");
        final File file = project.getFile();
        final Path path = file.toPath();
        final Path path1 = path.toAbsolutePath();
        getLog().info(path1.toString());
    }

    public void setProject(MavenProject project) {
        this.project = project;
    }
}
