package com.github.volodya_lombrozo.conventional_commit_linter.format;

public class FreeFormat implements Format {
    @Override
    public String regexp() {
        return "^(?!\\s*$).+";
    }

    @Override
    public String toString() {
        return String.format("FreeFormatPattern[%s]", regexp());
    }
}
