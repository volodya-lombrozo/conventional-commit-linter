package com.github.volodya_lombrozo.conventional_commit_linter;

import com.github.volodya_lombrozo.conventional_commit_linter.format.ConventionalFormat;
import com.github.volodya_lombrozo.conventional_commit_linter.git.GitCommits;
import com.github.volodya_lombrozo.conventional_commit_linter.validator.*;

public enum Scan {
    ALL {
        @Override
        public Validator validator() {
            return new AllCommitsValidator(new GitCommits(), new ConventionalFormat());
        }
    },
    LAST {
        @Override
        public Validator validator() {
            return new LastCommitValidator(new GitCommits(), new ConventionalFormat());
        }
    },
    NOTHING {
        @Override
        public Validator validator() {
            return new FakeValidator();
        }
    };

    public abstract Validator validator();

}
