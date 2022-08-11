package OOP.SOLID_Exercise;

import OOP.SOLID_Exercise.products.Product;

import java.util.List;

public class CalorieCalculator {

    private final Printer printer;

    private static final String SUM_FORMAT = "Sum: %f";
    private static final String AVERAGE_FORMAT = "Average: %f";

    public CalorieCalculator(Printer printer) {
        this.printer = printer;
    }


    public double sum(List<Product> products) {
        final double sum = products.stream()
                .mapToDouble(Product::getAmountOfCalories)
                .sum();

        print(SUM_FORMAT, sum);
        return sum;
    }

    public double average(List<Product> products) {
        final double amount = sum(products) / products.size();
        print(AVERAGE_FORMAT, amount);
        return amount;
    }

    public void print(String format, double amount) {
        this.printer.print(format, amount);
    }


}
