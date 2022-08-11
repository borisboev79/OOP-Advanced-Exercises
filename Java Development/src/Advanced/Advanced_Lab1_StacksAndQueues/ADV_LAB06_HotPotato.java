package Advanced.Advanced_Lab1_StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;
public class ADV_LAB06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        ArrayDeque<String> potato = new ArrayDeque<>();
        for (int i = 0; i < kids.length; i++) {
            potato.offer(kids[i]);
        }
        int n = Integer.parseInt(scanner.nextLine());
       while(potato.size() > 1) {
           for (int i = 1; i < n; i++) {
               String pass = potato.poll();
               potato.offer(pass);
           }
           System.out.println("Removed " + potato.poll());
       }
        System.out.println("Last is " + potato.poll());

    }
}
