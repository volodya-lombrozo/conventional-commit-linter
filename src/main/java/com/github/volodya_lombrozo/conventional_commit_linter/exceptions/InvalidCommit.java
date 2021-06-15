package com.github.volodya_lombrozo.conventional_commit_linter.exceptions;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;

import java.io.IOException;

public class InvalidCommit extends Exception {

    public InvalidCommit(Commits commits, Format format, IOException ioe){
        super(String.format("Fail during validation of Commits[%s] by the Format[%s]", commits, format), ioe);
    }

    public InvalidCommit(Commit commit, Format format) {
        super(String.format("Commit %s not matches with the next format: %s . Please, change the commit formatting.", commit, format));
    }

    public InvalidCommit(String message) {
        super(message);
    }
}
