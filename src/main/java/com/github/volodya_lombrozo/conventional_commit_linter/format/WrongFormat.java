package com.github.volodya_lombrozo.conventional_commit_linter.format;

import java.util.UUID;

public class WrongFormat implements Format {
    @Override
    public String regexp() {
        return UUID.randomUUID().toString();
    }
}
