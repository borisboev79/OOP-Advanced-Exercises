package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;
import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);


        Map<String, Integer> cookedPastries = new LinkedHashMap<>();

        cookedPastries.put("Biscuit", 0);
        cookedPastries.put("Cake", 0);
        cookedPastries.put("Pie", 0);
        cookedPastries.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {


            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;



            String cookedPastry;

            switch (sum) {
                case 25:
                    cookedPastry = "Biscuit";
                    break;
                case 50:
                    cookedPastry = "Cake";
                    break;
                case 75:
                    cookedPastry = "Pastry";
                    break;
                case 100:
                    cookedPastry = "Pie";
                    break;
                default:
                    cookedPastry = null;
                    break;

            }
            if (cookedPastry != null) {
                cookedPastries.put(cookedPastry, cookedPastries.get(cookedPastry) + 1);
            } else {
                ingredientsStack.push( ingredient + 3);
            }}

        int atLeastOnePastryOfType = cookedPastries.values().stream().mapToInt(Integer::intValue).min().getAsInt();

        if (atLeastOnePastryOfType > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquidsQueue.isEmpty() ? "none" : liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + remainingLiquids);


        String remainingIngredients = ingredientsStack.isEmpty() ? "none" : ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + remainingIngredients);


        cookedPastries.entrySet().forEach(e -> System.out.println((e.getKey() + ": " + e.getValue())));

    }
}
