package Advanced.Advanced_Lab5_FunctionalProgramming;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ADV_LAB04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<Double> printer = d -> System.out.printf("%.2f%n", d);

        UnaryOperator<Double> addVat = p -> p * 1.20;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(printer);
    }
}
