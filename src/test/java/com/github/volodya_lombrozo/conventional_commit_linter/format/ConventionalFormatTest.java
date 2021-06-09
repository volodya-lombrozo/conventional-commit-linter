package com.github.volodya_lombrozo.conventional_commit_linter.format;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConventionalFormatTest {

    private final String commit;
    private final boolean matches;
    public final static Pattern pattern = Pattern.compile(new ConventionalFormat().regexp());

    public ConventionalFormatTest(String commit, boolean matches) {
        this.commit = commit;
        this.matches = matches;
    }

    @Test
    public void regexp() {
        final Matcher matcher = pattern.matcher(commit);
        assertEquals(errMessage(), matches, matcher.matches());
    }

    private String errMessage() {
        if (matches) {
            return String.format("COMMIT MESSAGE \n'%s'\n SHOULD BE CORRECT", commit);
        } else {
            return String.format("COMMIT MESSAGE \n'%s'\n SHOULDN'T BE CORRECT", commit);
        }
    }

    @Parameterized.Parameters(name = "{index}: Commit message `{0}` = {1}")
    public static Iterable<Object[]> examples() {
        return Arrays.asList(new Object[][]{
                {"feat: allow provided config object to extend other configs\n" + "\n" + "BREAKING CHANGE: `extends` key in config file is now used for extending other config files", true},
                {"feat!: message", true},
                {"feat: message", true},
                {"FEAT: message", true},
                {"FIX: message", true},
                {"refactor!: drop support for Node 6", true},
                {"refactor!: drop support for Node 6\n" + "\n" + "body\n" + "\n" + "BREAKING CHANGE: refactor to use JavaScript features not available in Node 6.", true},
                {"refactor!: drop support for Node 6\n" + "\n" + "BREAKING CHANGE: refactor to use JavaScript features not available in Node 6.", true},
                {"refactor!: drop support for Node 6\n" + "\n" + "body\n" + "\n" + "breaking change: refactor to use JavaScript features not available in Node 6.", false},
                {"docs: correct spelling of CHANGELOG", true},
                {"feat(lang): add polish language", true},
                {"fix: correct minor typos in code\n" + "\n" + "see the issue for details\n" + "\n" + "on typos fixed.\n" + "\n" + "Reviewed-by: Z\n" + "Refs #133", false},
                {"fix: correct minor typos in code\n" + "\n" + "body\n" + "\n" + "Bad footer: Z\n" + "AnotherBadFooter ?133", false},
                {"fix:without space", false},
                {"", false},
                {"nothing", false},
                {"():", false},
                {":", false}
        });
    }
}