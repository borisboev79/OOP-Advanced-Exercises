package Advanced.Advanced_Lab5_FunctionalProgramming;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ADV_LAB02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, String> countFormatter = list -> "Count = " + list.size();
        Function<List<Integer>, Integer> sumAllElements = list -> list.stream().reduce(0, Integer::sum);

        String countOutput = countFormatter.apply(numbers);
        int sumOutput = sumAllElements.apply(numbers);

        System.out.println(countOutput);
        System.out.println("Sum = " + sumOutput);
    }
}
