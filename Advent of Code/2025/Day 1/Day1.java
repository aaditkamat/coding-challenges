/**
 * Advent of Code 2025 - Problem 1 Solution
 */
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.io.IOException;

public class Day1 {
    /**
     *  start is 50 and you parse each line 
     * if line is Rx then you add x and take modulus of 100 to get value
     * else you calculate as 100 + (start - x) % 100 if x > start else start - x 
     * if the value is equal to 0, you add one to the password counter (initialized to 0)
     * The final answer is the password counter
     */
    public static void part1(List<String> lines) {
        int start = 50;
        int passwordCtr = 0;
        for (String line: lines) {
            char symbol = line.charAt(0);
            int addValue = Integer.parseInt(line.substring(1));
            if (symbol == 'R') {
                start = (start + addValue) % 100;
            } else if (addValue > start) {
                start = (100 - Math.abs(start - addValue)) % 100;
            } else {
                start = start - addValue;
            }
            if (start == 0) {
                passwordCtr++;
            }
        }
        System.out.println("The password is: " + passwordCtr);
    }

    public static void part2(List<String> lines) {
        int start = 50;
        int passwordCtr = 0;
        int noOfRotations = 0;
        for (String line: lines) {
            char symbol = line.charAt(0);
            int addValue = Integer.parseInt(line.substring(1));
            if (symbol == 'R') {
                noOfRotations += (start + addValue) / 100;
                start = (start + addValue) % 100;
            } else if (addValue > start) {
                noOfRotations += Math.abs(start - addValue)/ 100 + 1;
                start = (100 - Math.abs(start - addValue)) % 100;
            } else {
                start = start - addValue;
            }
            if (start == 0) {
                passwordCtr++;
            }
        }
        System.out.println("The password is: " + (passwordCtr + noOfRotations));
    }

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("test1.txt"));
            part1(lines);
            part2(lines);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
