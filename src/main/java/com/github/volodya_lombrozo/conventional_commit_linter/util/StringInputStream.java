package com.github.volodya_lombrozo.conventional_commit_linter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class StringInputStream {

    private final InputStream is;

    public StringInputStream(InputStream is) {
        this.is = is;
    }

    public List<String> lines() throws IOException {
        try (is) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            return br.lines().collect(Collectors.toList());
        }
    }


}
