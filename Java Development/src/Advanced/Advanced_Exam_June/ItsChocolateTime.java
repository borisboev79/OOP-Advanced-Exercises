package Advanced.Advanced_Exam_June;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoStack::push);

        Map<String, Double> chocolateTypes = new TreeMap();

        chocolateTypes.put("Milk Chocolate", 0.0);
        chocolateTypes.put("Dark Chocolate", 0.0);
        chocolateTypes.put("Baking Chocolate", 0.0);

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {

            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();
            double result = (cacao / (cacao + milk)) * 100;

            String chocolate = null;

            if (result == 30.0) {
                chocolate = "Milk Chocolate";
            } else if (result == 50.00) {
                chocolate = "Dark Chocolate";
            } else if (result == 100.00) {
                chocolate = "Baking Chocolate";
            } else {
                milkQueue.offer(milk + 10.0);
            }
            if (chocolate != null) {
                chocolateTypes.put(chocolate, chocolateTypes.get(chocolate) + 1);
            }
        }

        double enoughChocolateProduced = chocolateTypes.values().stream().filter(v -> v > 0).mapToDouble(Double::doubleValue).count();

        if (enoughChocolateProduced >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolateTypes.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.println(String.format("# %s --> %.0f", e.getKey(), e.getValue())));

    }


}
