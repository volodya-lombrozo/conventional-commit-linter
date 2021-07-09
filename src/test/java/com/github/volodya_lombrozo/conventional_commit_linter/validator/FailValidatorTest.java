package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import org.junit.Test;

import static org.junit.Assert.*;

public class FailValidatorTest {

    @Test(expected = InvalidCommit.class)
    public void defaultConstructor() throws InvalidCommit {
        FailValidator validator = new FailValidator();

        validator.validate();

        fail();
    }
}