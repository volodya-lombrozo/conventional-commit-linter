package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;

public interface Validator {

    /**
     * Validates commit message.
     * Nothing happens if validation is successful.
     *
     * @throws InvalidCommit if validation fails
     */
    void validate() throws InvalidCommit;

}
