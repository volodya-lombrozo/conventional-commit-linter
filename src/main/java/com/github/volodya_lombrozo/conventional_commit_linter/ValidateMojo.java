package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;
import com.github.volodya_lombrozo.conventional_commit_linter.log.MojoLog;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.Validator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "scan", defaultPhase = LifecyclePhase.VALIDATE)
public class ValidateMojo extends AbstractMojo {

    @Parameter(property = "scan", defaultValue = "NOTHING")
    public String scan;

    private Log log = new MojoLog(getLog());

    @Override
    public void execute() throws MojoExecutionException {
        try {
            log.info(String.format("Scan strategy: %s", scan));
            Scan scanType = Scan.valueOf(this.scan);
            Validator validator = scanType.validator(log);
            validator.validate();
            log.info("Conventional commit validation passed");
        } catch (InvalidCommit invalidCommit) {
            log.error(invalidCommit);
            throw new MojoExecutionException("Conventional commit "
                    + "validation failed", invalidCommit);
        }
    }


    @Override
    public void setLog(final org.apache.maven.plugin.logging.Log logger) {
        super.setLog(logger);
        this.log = new MojoLog(logger);
    }
}
