package Advanced.Advanced_Lab1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ADV_LAB07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        ArrayDeque<String> potato = new ArrayDeque<>();
        for (int i = 0; i < kids.length; i++) {
            potato.offer(kids[i]);
        }
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        while (potato.size() > 1) {

            for (int i = 1; i < n; i++) {
                potato.offer(potato.poll());
            }
            counter++;

            if (!isPrime(counter)) {
                System.out.println("Removed " + potato.poll());
            } else {
                System.out.println("Prime " + potato.peek());
            }
        }
        System.out.println("Last is " + potato.poll());
    }

    private static boolean isPrime(int inputNumber) {
        if (inputNumber <= 1) {
            return false;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
