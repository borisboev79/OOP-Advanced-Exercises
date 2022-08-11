package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessStack::push);

        Map<String, Integer> cocktails = new TreeMap<>();

        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        while (!ingredientQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredient = ingredientQueue.poll();
            if (ingredient == 0) {
                continue;
            }
            int freshness = freshnessStack.pop();

            int result = ingredient * freshness;


            String cocktail = null;


            switch (result) {

                case 150:
                    cocktail = "Pear Sour";
                    break;
                case 250:
                    cocktail = "The Harvest";
                    break;
                case 300:
                    cocktail = "Apple Hinny";
                    break;
                case 400:
                    cocktail = "High Fashion";
                    break;
                default:
                    ingredientQueue.offer(ingredient + 5);

            }
            if (cocktail != null) {
                cocktails.put(cocktail, cocktails.get(cocktail) + 1);
            }

        }
        int check = cocktails.values().stream().mapToInt(Integer::intValue).min().getAsInt();
        if (check > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientQueue.isEmpty()) {
            System.out.println("Ingredients left: " + ingredientQueue.stream().mapToInt(Integer::intValue).sum());
        }
        cocktails.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue()));
    }

}


