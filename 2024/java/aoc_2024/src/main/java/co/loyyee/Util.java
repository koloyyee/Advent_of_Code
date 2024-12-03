package co.loyyee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Util {

    public static List<String> readFile(String filename) throws IOException {
        Path path = Path.of("src", "main", "resources", filename);
        // try (BufferedReader rdr = new BufferedReader(new InputStreamReader(Files.newInputStream(path)))) {
				// 	return rdr.lines().toList();	
        // }
        return Files.readAllLines(path);
    }
}
