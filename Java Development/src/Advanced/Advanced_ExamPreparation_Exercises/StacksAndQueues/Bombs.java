package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectsQueue = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(casingsStack::push);

        Map<String, Integer> bombs = new TreeMap<>();

        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        boolean targetReached = false;

        while (!effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            int effect = effectsQueue.peek();
            int casing = casingsStack.pop();
            int sum = effect + casing;

            String bomb;

            switch (sum) {
                case 40:
                    bomb = "Datura Bombs";
                    break;
                case 60:
                    bomb = "Cherry Bombs";
                    break;
                case 120:
                    bomb = "Smoke Decoy Bombs";
                    break;
                default:
                    bomb = null;
                    break;
            }

            if (bomb != null) {
                bombs.put(bomb, bombs.get(bomb) + 1);
                effectsQueue.poll();
//                if (bombs.values().stream().min(Comparator.comparingInt(Integer::intValue)).get() >= 3) {
//                    targetReached = true;
                targetReached = bombs.values().stream().allMatch(n -> n >= 3);
            } else {
                casingsStack.push(casing - 5);
            }
            if(targetReached) {
                break;
            }
        }

        if (targetReached) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        String remainingLiquids = effectsQueue.isEmpty() ? "empty" : effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Bomb Effects: " + remainingLiquids);


        String remainingIngredients = casingsStack.isEmpty() ? "empty" : casingsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Bomb Casings: " + remainingIngredients);


        bombs.entrySet().forEach(e -> System.out.println((e.getKey() + ": " + e.getValue())));


    }
}
