package Advanced.Advanced_Exercise1_StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;
public class ADV_EXS01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
        for (Integer integer : stack) {
            System.out.print(stack.pop() + " " );
        }
    }
}
