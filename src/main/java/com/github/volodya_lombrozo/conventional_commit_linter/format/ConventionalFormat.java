package com.github.volodya_lombrozo.conventional_commit_linter.format;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Conventional Commit specification link:
 * [https://www.conventionalcommits.org/en/v1.0.0-beta.4/].
 */
public final class ConventionalFormat implements Format {

    /**
     * Allowed types collection.
     */
    private final List<String> types;

    /**
     * Default constructor with a predefined list of conventional types.
     * The types will be used in regexp.
     */
    public ConventionalFormat() {
        this("feat", "fix", "style", "test", "refactor", "docs", "chore");
    }

    /**
     * The constructor accepts variable-length array of conventional types.
     * The types will be used in regexp.
     *
     * @param typesArray - variable-length of conventional types
     */
    public ConventionalFormat(final String... typesArray) {
        this(Arrays.asList(typesArray));
    }

    /**
     * The constructor accepts a collection of conventional types.
     * The types will be used in regexp.
     *
     * @param typesList - collection of conventional types
     */
    public ConventionalFormat(final List<String> typesList) {
        this.types = typesList;
    }

    @Override
    public String regexp() {
        final Stream<String> lower = types.stream().map(String::toLowerCase);
        final Stream<String> upper = types.stream().map(String::toUpperCase);
        final String typesEnumeration = Stream.concat(lower, upper)
                .collect(Collectors.joining("|"));
        final String regexp = "^(%s)((\\(.+\\))?+)(!?+): (.+)"
                + "(((\n{2})(.+))?+)(((\n{2})((?!breaking change).+))?+)";
        return String.format(regexp, typesEnumeration);
    }

    @Override
    public String toString() {
        String allTypes = this.types.stream()
                .collect(Collectors.joining(", ", "(", ")"));
        String url = "https://www.conventionalcommits.org/en/v1.0.0-beta.4/";
        return new StringJoiner(", ", "ConventionalFormat[", "]")
                .add("Allowed types=" + allTypes)
                .add("Version=" + url)
                .toString();
    }
}
