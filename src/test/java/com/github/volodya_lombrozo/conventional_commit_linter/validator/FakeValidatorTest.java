package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import org.junit.Test;

public class FakeValidatorTest {

    @Test
    public void defaultConstructor() {
        FakeValidator validator = new FakeValidator();

        validator.validate();
    }

}