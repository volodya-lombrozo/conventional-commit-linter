package com.github.volodya_lombrozo.conventional_commit_linter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class StringInputStream {

    /**
     * An input stream that will be read.
     */
    private final InputStream is;

    /**
     * @param inputStream - an input stream that will
     *                    be converted to string further.
     */
    public StringInputStream(final InputStream inputStream) {
        this.is = inputStream;
    }

    /**
     * Converts a raw InputStream to a simple string.
     *
     * @return list of lines joined to a single string.
     * @throws IOException if reading lines were unsuccessful.
     */
    public String toText() throws IOException {
        return String.join("\n", lines());
    }

    /**
     * Converts a raw InputStream to a list of strings.
     *
     * @return list of strings
     * @throws IOException if reading lines were unsuccessful.
     */
    public List<String> lines() throws IOException {
        try (is) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            return br.lines().collect(Collectors.toList());
        }
    }


}
