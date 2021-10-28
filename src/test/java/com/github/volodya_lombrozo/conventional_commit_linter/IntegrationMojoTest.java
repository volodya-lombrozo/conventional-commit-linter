package com.github.volodya_lombrozo.conventional_commit_linter;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.testing.MojoRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class IntegrationMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();

    @Test
    public void scanNothing() throws Exception {
        final Mojo mojo = createMojo(nothing());

        mojo.execute();
    }

    @Test(expected = MojoExecutionException.class)
    public void filedScan() throws Exception {
        Path failPom = fail();
        final Mojo mojo = createMojo(failPom);
        Log mockLog = Mockito.mock(Log.class);
        mojo.setLog(mockLog);

        mojo.execute();

        Assert.fail();
    }


    @Test
    public void withoutConfiguration() throws Exception {
        final ValidateMojo mojo = createMojo(without());

        assertEquals("LAST", mojo.getScan());
    }

    private ValidateMojo createMojo(Path pom) throws Exception {
        return (ValidateMojo) rule.lookupMojo("scan", pom.toFile());
    }

    private Path nothing() {
        return resources().resolve("test.pom.xml");
    }

    private Path without() {
        return resources().resolve("without_configuration.pom.xml");
    }

    private Path fail() {
        return resources().resolve("fail.pom.xml");
    }

    private Path resources() {
        return Path.of("src", "test", "resources");
    }
}