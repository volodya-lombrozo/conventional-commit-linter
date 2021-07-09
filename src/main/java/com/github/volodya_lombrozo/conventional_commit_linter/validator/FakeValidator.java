package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;

public class FakeValidator implements Validator {

    private final Log log;

    public FakeValidator() {
        this(new JavaLog());
    }

    public FakeValidator(Log log) {
        this.log = log;
    }

    @Override
    public void validate() {
        log.info("Validate by 'FakeValidator'. Nothing will be validated");
    }
}
