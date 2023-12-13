package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class File {
    public static List<String> read(String filename) {

        try {
            Path actual = Paths.get(System.getProperty("user.dir") + "/src/inputs/" + filename);
            return Files.readAllLines(actual);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readBuffered(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/inputs/" + filename));
            return br.lines().toList();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
