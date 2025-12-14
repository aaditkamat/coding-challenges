import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;

public class Day2 {
    public static void part1(String line) {
        String[] productIDRanges = line.split(",");
        long result = 0;
        for (String productIDRange: productIDRanges) {
            List<Long> nums = Stream.of(productIDRange.split("-")).map(Long::parseLong).collect(Collectors.toList());
            for (long i = nums.get(0); i <= nums.get(1); i++) {
                String numString = "" + i;
                if (numString.length() % 2 == 0 && numString.substring(0, numString.length() / 2).equals(numString.substring(numString.length() / 2, numString.length()))) {
                    result += i;
                }
            }
        }
        System.out.println("Result is: " + result);
    }

    public static void part2(String line) {
        String[] productIDRanges = line.split(",");
        long result = 0;
        for (String productIDRange: productIDRanges) {
            List<Long> nums = Stream.of(productIDRange.split("-")).map(Long::parseLong).collect(Collectors.toList());
            for (long i = nums.get(0); i <= nums.get(1); i++) {
                String numString = "" + i;
                for (int j = 1; j < numString.length(); j++) {
                    String substring = numString.substring(0, j);
                    String newString = "";
                    for (int k = 0; k < numString.length() / substring.length(); k++) {
                        newString += substring;
                    }
                    if (newString.equals(numString)) {
                        result += i;
                        break;
                    }
                }
            }
        }
        System.out.println("Result is: " + result);
    } 

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("Day2.txt"));
            part1(lines.get(0));
            part2(lines.get(0));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}