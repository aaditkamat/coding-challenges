import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class Day11 {

    public static void part1(List<String> lines) {
        Map<String, List<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();
        int noOfPaths = 0;
        for (String line : lines) {
            String mainNode = line.split(":")[0];
            List<String> otherNodes = Arrays.asList(
                line.split(": ")[1].split(" ")
            );
            graph.put(mainNode, otherNodes);
        }
        graph.put("out", new ArrayList<>());

        stack.push("you");
        while (!stack.isEmpty()) {
            String currentNode = stack.pop();
            if (currentNode.equals("out")) {
                noOfPaths += 1;
            } else {
                for (String node : graph.get(currentNode)) {
                    stack.push(node);
                }
            }
        }

        System.out.println("No of paths to out: " + noOfPaths);
    }

    public static void part2(List<String> lines) {
        Map<String, List<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();
        List<String> temp = new ArrayList<>();
        int noOfPaths = 0;
        for (String line : lines) {
            String mainNode = line.split(":")[0];
            List<String> otherNodes = Arrays.asList(
                line.split(": ")[1].split(" ")
            );
            graph.put(mainNode, otherNodes);
        }
        graph.put("out", new ArrayList<>());

        stack.push("svr");
        while (!stack.isEmpty()) {
            String currentNode = stack.pop();
            visited.add(currentNode);
            if (currentNode.equals("out")) {
                while (!stack.isEmpty()) {
                    temp.add(stack.pop());
                }
                System.out.println(temp);
                if (temp.contains("dac") && temp.contains("fft")) {
                    noOfPaths += 1;
                }
                for (int i = 0; i < temp.size(); i++) {
                    stack.push(temp.get(i));
                }
                temp.clear();
            } else {
                for (String node : graph.get(currentNode)) {
                    stack.push(node);
                }
            }
        }

        System.out.println(
            "No of paths from svr to out that visit both dac and fft: " +
                noOfPaths
        );
    }

    public static void main(String[] args) {
        try {
            List<String> part1Lines = Files.readAllLines(
                FileSystems.getDefault().getPath("Day11_part1.txt")
            );
            List<String> part2Lines = Files.readAllLines(
                FileSystems.getDefault().getPath("Day11_test_part2.txt")
            );
            part1(part1Lines);
            part2(part2Lines);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
