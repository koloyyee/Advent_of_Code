package Day01;

import utils.File;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//   Part 1
public class Trebuchet {
    public static void main(String[] args) {
        String sample = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """;

        List<String> sampleLines = List.of(sample.split("\n"));
//        List<String> fileLines = File.read("day01.txt");

        List<String> fileLines = File.readBuffered("day01.txt");

        // Part 1.
        Trebuchet.part1oo(fileLines);
        var fpTot = Trebuchet.part1fp(fileLines);
        System.out.println(fpTot);

        // Part 2.
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

        var part2 = Trebuchet.part2oo(fileLines, numMap);
        System.out.println(part2);
    }


    public static int part1oo(List<String> fileLines) {

        int total = 0;
        for (String line : fileLines) { // sample.split("\n")) {
            total += getCharSum(line);
        }
        System.out.println(total);
        return total;
    }

    public static int part1fp(List<String> fileLines) {
        return fileLines.stream()
                .map(line -> line.chars()
                                .filter(Character::isDigit)
                                .mapToObj(c -> c - '0')
//                        .mapToObj(c -> {
//                            System.out.println( c + "c" );
//                            System.out.println(c - '0' + "c -'0' ");
//                            return c - '0';
//                        })
                                .toList()
                )
                .mapToInt(list -> 10 * list.getFirst() + list.getLast())
                .sum();
    }

    public static int part2oo(List<String> fileLines, Map<String, String> numMap) {
        int total = 0;
        for (String line : fileLines) {
            for (Map.Entry<String, String> entry : numMap.entrySet()) {
                line = line.replace(entry.getKey(), entry.getValue());
            }
            total += Trebuchet.getCharSum(line);
        }
        System.out.println(total);
        return total;
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
