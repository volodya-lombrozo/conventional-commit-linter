package com.github.volodya_lombrozo.conventional_commit_linter.validator;

import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commit;
import com.github.volodya_lombrozo.conventional_commit_linter.commit.Commits;
import com.github.volodya_lombrozo.conventional_commit_linter.exceptions.InvalidCommit;
import com.github.volodya_lombrozo.conventional_commit_linter.format.Format;

import java.io.IOException;

public class AllCommitsValidator implements Validator {

    private final Commits commits;
    private final Format format;

    public AllCommitsValidator(Commits commits, Format format) {
        this.commits = commits;
        this.format = format;
    }


    @Override
    public void validate() throws InvalidCommit {
        try {
            tryValidate();
        } catch (IOException e) {
            throw new InvalidCommit(commits, format, e);
        }
    }

    private void tryValidate() throws IOException, InvalidCommit {
        for (Commit commit : commits.toQueue()) {
            CommitValidator validator = new CommitValidator(commit, format);
            validator.validate();
        }
    }
}
