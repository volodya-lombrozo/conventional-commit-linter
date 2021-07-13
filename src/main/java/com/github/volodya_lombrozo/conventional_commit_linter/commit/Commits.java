package com.github.volodya_lombrozo.conventional_commit_linter.commit;

import java.io.IOException;
import java.util.Deque;

public interface Commits {

    /**
     * @return the latest in time VCS commit;
     * @throws IOException if an VCS exception occurred during
     *                     the reading of commits
     */
    Commit last() throws IOException;

    /**
     * @return all commits from VCS from earlier to latest in time
     * @throws IOException if an VCS exception occurred during
     *                     the reading of commits
     */
    Deque<Commit> toQueue() throws IOException;

}
