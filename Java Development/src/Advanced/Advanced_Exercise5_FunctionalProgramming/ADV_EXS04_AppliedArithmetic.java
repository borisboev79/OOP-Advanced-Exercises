package Advanced.Advanced_Exercise5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ADV_EXS04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addFunction = numbersList -> numbersList.stream().map(el -> el + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunction = numbersList -> numbersList.stream().map(el -> el * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunction = numbersList -> numbersList.stream().map(el -> el - 1).collect(Collectors.toList());

        String line;

        while (!"end".equals(line = scanner.nextLine())) {
            switch (line) {
                case "add":
                    numbers = addFunction.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunction.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunction.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(number -> System.out.printf("%d ", number));
                    System.out.println();
                    break;
            }

        }
    }
}
