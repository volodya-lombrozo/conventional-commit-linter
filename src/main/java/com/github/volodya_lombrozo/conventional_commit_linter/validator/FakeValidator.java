package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;

public final class FakeValidator implements Validator {

    /**
     * Logging tool.
     */
    private final Log log;

    /**
     * Default constructor with the default logging tool.
     */
    public FakeValidator() {
        this(new JavaLog());
    }

    /**
     * @param logger - logging tool.
     */
    public FakeValidator(final Log logger) {
        this.log = logger;
    }

    @Override
    public void validate() {
        log.info("Validate by 'FakeValidator'. Nothing will be validated");
    }
}
