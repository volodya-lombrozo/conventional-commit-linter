package com.github.volodya_lombrozo.conventional_commit_linter.maven;

import java.io.File;
import java.util.Objects;
import java.util.stream.Stream;

public class MavenHome {

    public File toFile() {
        return new File(mavenHome());
    }

    private String mavenHome() {
        return Stream.of("maven.home", "m3_home", "m3home", "m2_home", "m2home", "maven_home", "mavenhome", "path")
                .map(System::getenv).filter(Objects::nonNull).findFirst().orElse("/usr");
    }

}
