package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;

public class FailValidator implements Validator{
    @Override
    public void validate() throws InvalidCommit {
        throw new InvalidCommit("Invalid commit");
    }
}
