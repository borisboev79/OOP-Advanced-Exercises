package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);


        Map<String, Integer> forgedSwords = new TreeMap();

        forgedSwords.put("Gladius", 0);
        forgedSwords.put("Shamshir", 0);
        forgedSwords.put("Katana", 0);
        forgedSwords.put("Sabre", 0);

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int carbon = carbonStack.pop();
            int sum = carbon + steelQueue.poll();



            String forgedSword;

            switch (sum) {
                case 70:
                    forgedSword = "Gladius";
                    break;
                case 80:
                    forgedSword = "Shamshir";
                    break;
                case 90:
                    forgedSword = "Katana";
                    break;
                case 110:
                    forgedSword = "Sabre";
                    break;
                default:
                    forgedSword = null;
                    break;

            }
            if (forgedSword != null) {
                forgedSwords.put(forgedSword, forgedSwords.get(forgedSword) + 1);
            } else {
                carbonStack.push(carbon + 5);
            }





        }
        int swordCount = forgedSwords.values().stream().mapToInt(Integer::intValue).sum();

        if (swordCount > 0) {
            System.out.printf("You have forged %d swords.%n", swordCount);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        String remainingSteel = steelQueue.isEmpty() ? "none" : steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Steel left: " + remainingSteel);

        String remainingCarbon = carbonStack.isEmpty() ? "none" : carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Carbon left: " + remainingCarbon);


        forgedSwords.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.println((e.getKey() + ": " + e.getValue())));

    }
}
