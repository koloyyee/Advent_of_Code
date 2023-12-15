package Day02;

import utils.File;

import java.util.*;

public class CubeConundrum {
    public static void main(String[] args) {
        String sample = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """;
        var fileLines = File.readBuffered("day02.txt");

        CubeConundrum.part1oo(fileLines);
    }
    public static int part1oo(List<String> fileLines) {

        ArrayList<String> games = new ArrayList<>();
        int sum = 0;
        for (String line : fileLines) {
            if (checkPossible(line)) {
                games.add(line);
            }
        }
        for (String game : games) {
            sum += getId(game);
        }
        System.out.println(sum);
        return sum;
    }
    public static int part2oo(List<String> fileLine) {
        //power
        return 1;
    }

    public static int getId(String game) {

        String[] splitted = game.split(":");
        Integer gameIdx = Integer.parseInt(splitted[0].replace("Game", "").trim());
        return gameIdx;
    }

    public static boolean checkPossible(String line) {
        final int red = 12;
        final int green = 13;
        final int blue = 14;

        String[] splitted = line.split(":");
        String[] gameRec = splitted[1].split("[,;]");

        boolean possibility = false;
        for (String set : gameRec) {
            String[] cube = set.trim().split(" ");
            if (cube[1].contains("red")) {
                if (Integer.parseInt(cube[0]) <= red) {
                    possibility = true;
                } else {
                    return false;
                }
            } else if (cube[1].contains("green")) {
                if (Integer.parseInt(cube[0]) <= green) {
                    possibility = true;
                } else {
                    return false;
                }
            } else if (cube[1].contains("blue")) {
                if (Integer.parseInt(cube[0]) <= blue) {
                    possibility = true;
                } else {
                    return false;
                }
            }
        }
        return possibility;
    }
}
