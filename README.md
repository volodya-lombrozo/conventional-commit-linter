# Conventional Commits Linter

Maven Plugin linter for [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/).  
[![codecov](https://codecov.io/gh/volodya-lombrozo/conventional-commit-linter/branch/main/graph/badge.svg?token=KmT35uwArr)](https://codecov.io/gh/volodya-lombrozo/conventional-commit-linter)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.volodya-lombrozo/conventional-commit-linter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.volodya-lombrozo/conventional-commit-linter)

# How to use
Add plugin to pom.xml (to plugins section)

            <plugin>
                <groupId>com.github.volodya-lombrozo</groupId>
                <artifactId>conventional-commit-linter</artifactId>
                <version>0.0.3</version>
                <configuration>
                    <scan>ALL</scan>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>
                                scan
                            </goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

The default maven phase is **validate**.

Available scan modes:
* ALL - the plugin will scan all repository commits messages one by one starting from the earliest. Conventional commits
  format will be used.
* LAST - the plugin will scan only the last commit. Conventional commits format will be used.
* NOTHING - the plugin will scan nothing. Validation will always be **successful** regardless of the commit messages.
* FAIL - the plugin will scan nothing. Validation will always be **failed** regardless of the commit messages.