package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class File{
    public static List<String> read(String filename) {

        try {
            Path actual = Paths.get(System.getProperty("user.dir") + "/src/" + filename);
            return Files.readAllLines(actual);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
