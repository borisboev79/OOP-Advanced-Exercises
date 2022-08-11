package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {

            firstBoxQueue.peek();
            int toBeAddedToQueue = secondBoxStack.pop();
            int sum = toBeAddedToQueue + firstBoxQueue.peek();

            if (sum % 2 == 0) {
                value += sum;
                firstBoxQueue.poll();
            } else {
                firstBoxQueue.offer(toBeAddedToQueue);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (value >= 90) {
            System.out.println("Your loot was epic! Value: " + value);
        } else {
            System.out.println("Your loot was poor... Value: " + value);
        }
    }
}
