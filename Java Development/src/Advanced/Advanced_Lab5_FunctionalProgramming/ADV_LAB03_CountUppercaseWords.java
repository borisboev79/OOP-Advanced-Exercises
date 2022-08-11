package Advanced.Advanced_Lab5_FunctionalProgramming;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ADV_LAB03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> starsWithUppercase = w ->Character.isUpperCase(w.charAt(0));
        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(starsWithUppercase)
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());

        Consumer<String> print = System.out::println;
        uppercaseWords.forEach(print);
    }
}
