package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.FakeCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;
import com.github.volodya_lombrozo.conventional_commit_linter.format.FreeFormat;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "scan")
public class ValidateMojo extends AbstractMojo {

    @Override
    public void execute() {
        try {
            getLog().info("Conventional commit validation phase started");
            final Commit commit = new FakeCommit();
            final Format format = new FreeFormat();
            final ConventionalCommit conventional = new ConventionalCommit(commit, format);
            conventional.validate();
            getLog().info("Conventional commit validation passed");
        } catch (InvalidCommit invalidCommit) {
            getLog().error(invalidCommit);
        }
    }
}
