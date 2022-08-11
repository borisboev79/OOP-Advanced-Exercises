package Advanced.Advanced_Exercise1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ADV_EXS02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int countToPush = Integer.parseInt(input[0]);
        int countToPop = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < countToPush; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }
        if(stack.contains(elementToSearch)){
            System.out.println("true");
        } else if(stack.isEmpty()) {
            System.out.println("0");

        }else {
            System.out.println(Collections.min(stack));
            //System.out.println(stack.stream().mapToInt(e -> e).min().getAsInt());
            //System.out.println(stack.stream().min(Integer::compare).get());
        }
        }
    }

