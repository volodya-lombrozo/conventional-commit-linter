package com.github.volodya_lombrozo.conventional_commit_linter.commit;

import java.io.IOException;
import java.util.Deque;

public interface Commits {

    Commit last() throws IOException;

    Deque<Commit> toQueue() throws IOException;

}
