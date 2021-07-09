package com.github.volodya_lombrozo.conventional_commit_linter.format;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Conventional Commit specification: https://www.conventionalcommits.org/en/v1.0.0-beta.4/
 * */
public class ConventionalFormat implements Format {

    private final List<String> types;

    public ConventionalFormat() {
        this("feat", "fix", "style", "test", "refactor", "docs", "chore");
    }

    public ConventionalFormat(String... types) {
        this(Arrays.asList(types));
    }

    public ConventionalFormat(List<String> types) {
        this.types = types;
    }

    @Override
    public String regexp() {
        final Stream<String> lower = types.stream().map(String::toLowerCase);
        final Stream<String> upper = types.stream().map(String::toUpperCase);
        final String types = Stream.concat(lower, upper).collect(Collectors.joining("|"));
        return String.format("^(%s)((\\(.+\\))?+)(!?+): (.+)(((\n{2})(.+))?+)(((\n{2})((?!breaking change).+))?+)", types);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "ConventionalFormat[", "]")
                .add("Allowed types=" + String.join(",", types))
                .add("Version https://www.conventionalcommits.org/en/v1.0.0-beta.4/")
                .toString();
    }
}
