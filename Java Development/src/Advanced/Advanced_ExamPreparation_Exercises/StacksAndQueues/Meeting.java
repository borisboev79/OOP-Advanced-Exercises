package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matches = 0;

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (female <= 0 && male <= 0) {
                malesStack.pop();
                femalesQueue.poll();
                continue;
            }
            if (male <= 0) {
                malesStack.pop();
                continue;
            }
            if (female <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (female % 25 == 0 && male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }

            if (male == female) {
                malesStack.pop();
                femalesQueue.poll();
                matches++;
            } else {
                femalesQueue.poll();
                malesStack.pop();
                malesStack.push(male - 2);
            }
        }

        System.out.printf("Matches: %d%n", matches);

        String remainingMales = malesStack.isEmpty() ? "none" : malesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Males left: " + remainingMales);

        String remainingFemales = femalesQueue.isEmpty() ? "none" : femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Females left: " + remainingFemales);


    }
}
