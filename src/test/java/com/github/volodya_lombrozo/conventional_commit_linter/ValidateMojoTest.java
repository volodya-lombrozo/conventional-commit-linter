package com.github.volodya_lombrozo.conventional_commit_linter;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.testing.MojoRule;
import org.codehaus.plexus.configuration.PlexusConfiguration;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

public class ValidateMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();

    @Test
    public void integration() throws Exception {
        final Mojo mojo = createMojo();

        mojo.execute();
    }

    private Mojo createMojo() throws Exception {
        return rule.lookupMojo("scan", new File("src/test/resources/test.pom.xml"));
    }

}