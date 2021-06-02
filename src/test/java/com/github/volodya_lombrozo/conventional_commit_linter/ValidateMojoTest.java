package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.maven.Clean;
import com.github.volodya_lombrozo.conventional_commit_linter.maven.Install;
import com.github.volodya_lombrozo.conventional_commit_linter.maven.Maven;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.shared.invoker.*;
import org.junit.*;

import java.io.File;

import static org.junit.Assert.assertNotNull;

public class ValidateMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();
    private final Maven maven = new Maven();

    @Before
    public void setUp() throws MavenInvocationException {
        maven.execute(new Install());
    }

    @After
    public void tearDown() throws Exception {
        maven.execute(new Clean());
    }

    @Test
    @Ignore("Not worked yet")//todo
    public void execute() throws Exception {
        final AbstractMojo verify = getMojo();

        assertNotNull(verify);
    }


    private AbstractMojo getMojo() throws Exception {
        final File pom = new File("src/test/resources/test.pom.xml");
        return (AbstractMojo) rule.lookupEmptyMojo("scan", pom);
    }

}