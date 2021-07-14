package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;

import java.util.regex.Pattern;

public final class CommitValidator implements Validator {
    /**
     * Commit from VCS.
     */
    private final Commit commit;

    /**
     * Allowed commit message format.
     */
    private final Format format;

    /**
     * @param verifiableCommit - verifiable commit from VCS.
     * @param allowedFormat    - allowed commit message format.
     */
    public CommitValidator(final Commit verifiableCommit,
                           final Format allowedFormat) {
        this.commit = verifiableCommit;
        this.format = allowedFormat;
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
