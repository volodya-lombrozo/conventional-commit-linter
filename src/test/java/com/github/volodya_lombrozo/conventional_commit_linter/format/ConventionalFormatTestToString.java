package com.github.volodya_lombrozo.conventional_commit_linter.format;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConventionalFormatTestToString {

    @Test
    public void toStringTest() {
        final ConventionalFormat format = new ConventionalFormat();
        final String expected = "ConventionalFormat[Allowed types=feat,fix,style,test,refactor,docs,chore, Version https://www.conventionalcommits.org/en/v1.0.0-beta.4/]";

        final String actual = format.toString();

        assertEquals(expected, actual);
    }
}
