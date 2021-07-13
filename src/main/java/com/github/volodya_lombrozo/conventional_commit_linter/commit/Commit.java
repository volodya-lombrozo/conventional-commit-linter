package com.github.volodya_lombrozo.conventional_commit_linter.commit;

public interface Commit {

    /**
     * @return commit message from VCS
     */
    String message();

}
