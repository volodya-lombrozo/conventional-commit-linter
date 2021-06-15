package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;

import java.util.regex.Pattern;

public class CommitValidator implements Validator {
    private final Commit commit;
    private final Format format;

    public CommitValidator(Commit commit, Format format) {
        this.commit = commit;
        this.format = format;
    }

    @Override
    public void validate() throws InvalidCommit {
        var pattern = Pattern.compile(format.regexp());
        var matcher = pattern.matcher(commit.message());
        if (!matcher.matches()) {
            throw new InvalidCommit(commit, format);
        }
    }
}
