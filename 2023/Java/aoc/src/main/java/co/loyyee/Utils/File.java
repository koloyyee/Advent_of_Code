package co.loyyee.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class File {

    public static List<String> read(String filename) {

        try {
            Path path = Paths.get(System.getProperty("user.dir")).resolve("files").resolve(filename);
            // Path actual = Paths.get(System.getProperty("user.dir") + "/src/inputs/" + filename);
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readBuffered(String filename) {
        Path path = Paths.get(System.getProperty("user.dir")).resolve("files").resolve(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()));) {
            return br.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
