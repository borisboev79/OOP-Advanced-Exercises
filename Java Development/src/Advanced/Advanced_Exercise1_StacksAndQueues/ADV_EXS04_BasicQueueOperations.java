package Advanced.Advanced_Exercise1_StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class ADV_EXS04_BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int countToOffer = Integer.parseInt(input[0]);
        int countToPoll = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < countToOffer; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < countToPoll; i++) {
            queue.poll();
        }
        if(queue.contains(elementToSearch)){
            System.out.println("true");
        } else if(queue.isEmpty()) {
            System.out.println("0");

        }else {
            System.out.println(Collections.min(queue));
            //System.out.println(stack.stream().mapToInt(e -> e).min().getAsInt());
            //System.out.println(stack.stream().min(Integer::compare).get());
        }
    }
}
