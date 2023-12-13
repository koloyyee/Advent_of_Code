package Day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trebuchet2 {
    public static void main(String[] args) {
        String sample = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
                """;

        Map<String, String> numMap = new HashMap<>();
        numMap.put("one", "one1one");
        numMap.put("two", "two2two");
        numMap.put("three", "three3three");
        numMap.put("four", "four4four");
        numMap.put("five", "five5five");
        numMap.put("six", "six6six");
        numMap.put("seven", "seven7seven");
        numMap.put("eight", "eight8eight");
        numMap.put("nine", "nine9nine");

        Path actual = Paths.get(System.getProperty("user.dir") + "/src/Day01/input.txt");
        try {
            List<String> fileLines = Files.readAllLines(actual);
            List<String> sampleLines = List.of(sample.split("\n"));
            oo( fileLines, numMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int oo(List<String> fileLines, Map<String, String> numMap) {
        int total = 0;
        for( String line : fileLines) {
            for(Map.Entry<String, String> entry : numMap.entrySet()) {
                line = line.replace(entry.getKey(), entry.getValue());
            }
            total += Trebuchet1.getCharSum(line);
        }
        System.out.println(total);
        return total;
    }
}
