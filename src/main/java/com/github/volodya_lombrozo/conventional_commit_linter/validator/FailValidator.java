package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;

public final class FailValidator implements Validator {

    /**
     * Logging tool.
     */
    private final Log log;

    /**
     * Default constructor with the default logging tool.
     */
    public FailValidator() {
        this(new JavaLog());
    }

    /**
     * @param logger - logging tool.
     */
    public FailValidator(final Log logger) {
        this.log = logger;
    }

    @Override
    public void validate() throws InvalidCommit {
        log.info("Validate by 'FailValidator'."
                + " InvalidCommit exception will be thrown");
        throw new InvalidCommit("Invalid commit");
    }
}
