package Advanced.Advanced_Exercise5_FunctionalProgramming;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class ADV_EXS03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNum = arr -> Arrays.stream(numbers).min().getAsInt();
       // Function<int[], Integer> minNum = arr -> Collections.min(Arrays.stream(arr).boxed().collect));


        System.out.println(minNum.apply(numbers));
    }
}
