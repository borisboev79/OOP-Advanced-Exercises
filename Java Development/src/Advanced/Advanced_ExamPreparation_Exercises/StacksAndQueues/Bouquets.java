package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tulipStack::push);

        ArrayDeque<Integer> daffodilsQueue = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int bouquetCount = 0;
        int leftovers = 0;

        while (!tulipStack.isEmpty() && !daffodilsQueue.isEmpty()) {

            int daffodil = daffodilsQueue.poll();
            int tulip = tulipStack.pop();


            int sum = tulip + daffodil;

            while (sum > 15) {
                tulip -= 2;
                sum = tulip + daffodil;
            }

            if (sum == 15) {
                bouquetCount++;
            } else {
                leftovers += sum;
            }
        }

        int leftoverWraths = leftovers / 15;

        bouquetCount += leftoverWraths;

        if (bouquetCount >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquetCount + " bouquets!");
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetCount);
        }
    }

}
