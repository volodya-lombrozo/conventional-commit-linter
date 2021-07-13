package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.format.ConventionalFormat;
import com.github.volodya_lombrozo.conventional_commit_linter.git.GitCommits;
import com.github.volodya_lombrozo.conventional_commit_linter.log.JavaLog;
import com.github.volodya_lombrozo.conventional_commit_linter.log.Log;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.AllCommitsValidator;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.FailValidator;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.FakeValidator;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.LastCommitValidator;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.Validator;

public enum Scan {
    ALL {
        @Override
        public Validator validator(final Log log) {
            return new AllCommitsValidator(new GitCommits(), new ConventionalFormat(), log);
        }
    },
    LAST {
        @Override
        public Validator validator(final Log log) {
            return new LastCommitValidator(new GitCommits(), new ConventionalFormat(), log);
        }
    },
    NOTHING {
        @Override
        public Validator validator(final Log log) {
            return new FakeValidator(log);
        }
    },
    FAIL {
        @Override
        public Validator validator(final Log log) {
            return new FailValidator(log);
        }
    };

    public Validator validator() {
        return this.validator(new JavaLog());
    }

    public abstract Validator validator(Log log);

}
