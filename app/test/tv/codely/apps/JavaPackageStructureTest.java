package tv.codely.apps;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class JavaPackageStructureTest {

    @Test
    void javaPackagesMatchTheirDirectoryStructure() throws IOException {
        List<Path> sourceRoots = Arrays.asList(
            Paths.get("app/main"),
            Paths.get("src/mooc/main"),
            Paths.get("src/shared/main")
        );

        for (Path sourceRoot : sourceRoots) {
            if (Files.notExists(sourceRoot)) {
                continue;
            }

            try (Stream<Path> files = Files.walk(sourceRoot)) {
                files
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> assertPackageMatchesPath(sourceRoot, path));
            }
        }
    }

    private void assertPackageMatchesPath(Path sourceRoot, Path javaFile) {
        String packageName = readPackageName(javaFile)
            .orElseThrow(() -> new AssertionError("Missing package declaration in " + javaFile));

        Path expectedDirectory = sourceRoot.resolve(packageName.replace('.', '/'));
        Path actualDirectory = javaFile.getParent();

        assertEquals(
            expectedDirectory.normalize(),
            actualDirectory.normalize(),
            "Package declaration does not match file path for " + javaFile
        );
    }

    private Optional<String> readPackageName(Path javaFile) {
        try (Stream<String> lines = Files.lines(javaFile, StandardCharsets.UTF_8)) {
            return lines
                .map(String::trim)
                .filter(line -> line.startsWith("package "))
                .map(line -> line.substring("package ".length(), line.length() - 1))
                .findFirst();
        } catch (IOException exception) {
            throw new AssertionError("Could not read " + javaFile, exception);
        }
    }
}
