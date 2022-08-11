package Advanced.Advanced_Lab1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ADV_LAB03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if (decimal == 0) {
            System.out.println(0);
        } else {
            while (decimal != 0) {
                binary.push(decimal % 2);
                decimal /= 2;
            }
            while (!binary.isEmpty()) {
                System.out.print(binary.pop());
            }
        }
    }
}
