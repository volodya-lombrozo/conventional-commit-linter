package com.github.volodya_lombrozo.conventional_commit_linter;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.testing.MojoRule;
import org.codehaus.plexus.configuration.PlexusConfiguration;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;

public class ValidateMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();

    @Test
    public void execute() throws Exception {
        final Mojo verify = fromFile();

        verify.execute();

        assertNotNull(verify);
    }


    @Test
    public void integration() throws Exception {
        final Mojo mojo = createMojo();

        mojo.execute();
    }

    private Mojo createMojo() throws Exception {
        final File pom = new File("src/test/resources/test.pom.xml");
        final PlexusConfiguration configuration = rule.extractPluginConfiguration("conventional-commit-linter", pom);
        return rule.configureMojo(new ValidateMojo(), configuration);
    }

    private Mojo fromFile() throws Exception {
        final File pom = new File("src/test/resources/test.pom.xml");
        final PlexusConfiguration configuration = rule.extractPluginConfiguration("conventional-commit-linter", pom);
        return rule.lookupEmptyMojo("scan", pom);

    }

}