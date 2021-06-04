package com.github.volodya_lombrozo.conventional_commit_linter.exceptions;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.rule.Format;

public class InvalidCommit extends Exception {

    public InvalidCommit(Commit commit, Format format) {
        super(String.format("Commit %s not matches with the next format: %s . Please, change the commit formatting.", commit, format));
    }

}
