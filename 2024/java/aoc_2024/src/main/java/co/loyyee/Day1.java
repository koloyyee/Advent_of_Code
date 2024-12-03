package co.loyyee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) {
        try {
            List<String> lines = Util.readFile("01.txt");

            List<Integer> firsts = new ArrayList<>();
            List<Integer> lasts = new ArrayList<>();

            Pattern p = Pattern.compile("(\\d+)\\D+(\\d+)");
            for (String line : lines) {
                Matcher m = p.matcher(line);
                while (m.find()) {
                    firsts.add(Integer.valueOf(m.group(1)));
                    lasts.add(Integer.valueOf(m.group(2)));
                }
            }
						Collections.sort(firsts);
						Collections.sort(lasts);
            pt1(firsts, lasts);
						System.out.println(pt2(firsts, lasts));
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        }
    }

    static int pt1(final List<Integer> firsts, final List<Integer> lasts) {
        int sum = 0;
        for (int i = 0; i < firsts.size(); i++) {
            sum += (Math.abs(firsts.get(i) - lasts.get(i)));
        }
        return sum;
    }

    static int pt2(List<Integer> firsts, List<Integer> lasts ) {
				Map<Integer, Integer> lastsMap = lasts.stream().collect(Collectors.groupingBy(el -> el, Collectors.summingInt(e -> 1)));
				List<Integer> counts = new ArrayList<>();
				for( int f : firsts) {
					counts.add(f * lastsMap.getOrDefault(f, 0));
				}
				return counts.stream().mapToInt(Integer::intValue).sum();
    }
}
