package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.testing.MojoRule;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.nio.file.Path;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class IntegrationMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();

    @Test
    public void scanNothing() throws Exception {
        final Mojo mojo = createMojo(nothing());

        mojo.execute();
    }

    @Test
    public void filedScan() throws Exception {
        Path failPom = fail();
        final Mojo mojo = createMojo(failPom);
        Log mockLog = Mockito.mock(Log.class);
        mojo.setLog(mockLog);

        mojo.execute();

        verify(mockLog).error(any(InvalidCommit.class));
    }

    private Mojo createMojo(Path pom) throws Exception {
        return rule.lookupMojo("scan", pom.toFile());
    }

    private Path nothing() {
        return resources().resolve("test.pom.xml");
    }

    private Path fail() {
        return resources().resolve("fail.pom.xml");
    }

    private Path resources() {
        return Path.of("src", "test", "resources");
    }
}