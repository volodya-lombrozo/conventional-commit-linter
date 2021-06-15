package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;

public interface Validator {

    void validate() throws InvalidCommit;

}
