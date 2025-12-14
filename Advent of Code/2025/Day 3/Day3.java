import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;

public class Day3 {
    public static void part1(List<String> lines) {
        int result = 0;
        for (String line: lines) {
            List<Integer> digitStrs = Stream.of(line.split("")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> sortedDigitStrs = digitStrs.clone();
            Collections.sort(sortedDigitStrs, (a, b) -> b - a);
            String store = "";
            for (int i = 0; i < digitStrs.length(); i++) {
                if (digitStrs.get(i) == sortedDigitStrs.get(0) || digitStrs.get(i) == sortedDigitStrs.get(1)) {
                    store += "" + digitStrs.get(i);
                } 
                if (store.length() == 2) break;
            }
            result += Integer.parseInt(store);
        }
        System.out.println("Result is: " + result);
    }

    public static void part2(List<String> lines) {
    } 

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("Day3_test.txt"));
            part1(lines);
            part2(lines);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}