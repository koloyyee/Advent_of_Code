package Day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//   Part 1
public class Trebuchet1 {
    public static void main(String[] args) {
        String sample = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """;

        Path actual = Paths.get(System.getProperty("user.dir") + "/src/Day01/input.txt");
        try {
            List<String> fileLines = Files.readAllLines(actual);
            List<String> sampleLines = List.of(sample.split("\n"));
            oo(fileLines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static int oo(List<String> fileLines) {

        int total = 0;
        for (String line : fileLines) { // sample.split("\n")) {
           total += getCharSum(line);
        }
        System.out.println(total);
        return total;
    }

    public static int fp(List<String> fileLines) {
        return 0;
    }

    public static int getCharSum(String line) {
        char[] chars = line.toCharArray();
        int first = -1;
        int second = -1;

        for (char c : chars) {
            if (Character.isDigit(c)) {

                if (first == -1) {
                    first = Character.getNumericValue(c);
                } else {
                    second = Character.getNumericValue(c);
                }
            }
        }
        if (second == -1) {
            second = first;
        }
        first *= 10;
        return first + second;

    }
}
