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

    /**
     * The plugin will scan all repository commits messages
     * one by one starting from the earliest.
     * Conventional commits format will be used.
     */
    ALL {
        @Override
        public Validator validator(final Log log) {
            return new AllCommitsValidator(new GitCommits(),
                    new ConventionalFormat(),
                    log);
        }
    },

    /**
     * The plugin will scan only the last commit.
     * Conventional commits format will be used.
     */
    LAST {
        @Override
        public Validator validator(final Log log) {
            return new LastCommitValidator(new GitCommits(),
                    new ConventionalFormat(),
                    log);
        }
    },

    /**
     * The plugin will scan nothing. Validation will always be
     * successful regardless of the commit messages.
     */
    NOTHING {
        @Override
        public Validator validator(final Log log) {
            return new FakeValidator(log);
        }
    },

    /**
     * The plugin will scan nothing. Validation will always be
     * failed regardless of the commit messages.
     */
    FAIL {
        @Override
        public Validator validator(final Log log) {
            return new FailValidator(log);
        }
    };

    /**
     * @return a predefined validator depending on the scan mode.
     */
    public Validator validator() {
        return this.validator(new JavaLog());
    }

    protected abstract Validator validator(Log log);

}
