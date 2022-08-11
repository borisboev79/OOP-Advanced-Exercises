package OOP.Encapsulation_Exercise.E04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaData = scanner.nextLine().split("\\s+");

        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughInput = scanner.nextLine().split("\\s+");

            String doughType = doughInput[1];
            String bakingTechnique = doughInput[2];
            double doughWeight = Double.parseDouble(doughInput[3]);

            Dough dough = new Dough(doughType, bakingTechnique, doughWeight);
            pizza.setDough(dough);

            String toppingsInput = scanner.nextLine();

            while (!"END".equals(toppingsInput)) {
                String[] toppingInput = toppingsInput.split("\\s+");

                String toppingType = toppingInput[1];
                double toppingWeight = Double.parseDouble(toppingInput[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
                toppingsInput = scanner.nextLine();
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
