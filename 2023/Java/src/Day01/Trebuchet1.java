package Day01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jdk.internal.icu.util.CodePointMap.StringIterator;

//   Part 1
public class Trebuchet1 {

    public static void main(String[] args) {

        try {

            Path path = Paths.get(System.getProperty("user.dir") + "/Java/src/Day01/input.txt");
            List<String> filelines = Files.readAllLines(path);

            for (String line : filelines) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
