package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;

public class FailValidator implements Validator {

    private final Log log;

    public FailValidator() {
        this(new JavaLog());
    }

    public FailValidator(Log log) {
        this.log = log;
    }

    @Override
    public void validate() throws InvalidCommit {
        log.info("Validate by 'FailValidator'. InvalidCommit exception will be thrown");
        throw new InvalidCommit("Invalid commit");
    }
}
