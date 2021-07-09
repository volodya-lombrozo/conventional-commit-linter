package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;
import com.github.volodya_lombrozo.conventional_commit_linter.log.MojoLog;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.Validator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "scan", defaultPhase = LifecyclePhase.VALIDATE)
public class ValidateMojo extends AbstractMojo {

    @Parameter(property = "scan", defaultValue = "NOTHING")
    public String scan;

    private final Log log = new MojoLog(getLog());

    @Override
    public void execute() {
        try {
            Scan scanType = Scan.valueOf(this.scan);
            Validator validator = scanType.validator();
            validator.validate();
            log.info("Conventional commit validation passed");
        } catch (InvalidCommit invalidCommit) {
            log.error(invalidCommit);
        }
    }
}
