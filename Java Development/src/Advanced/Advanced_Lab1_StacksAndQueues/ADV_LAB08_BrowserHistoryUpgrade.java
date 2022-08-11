package Advanced.Advanced_Lab1_StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;
public class ADV_LAB08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentURL = "blank page";

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (!history.isEmpty()) {
                    forward.addFirst(currentURL);
                    currentURL = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else if (input.equals("forward")){
                    if(!forward.isEmpty()){
                        currentURL = forward.poll();

                    } else {
                        System.out.println("no next URLs");
                        currentURL = "blank page";
                    }

            } else {
                if(!currentURL.equals("blank page")){
                    history.push(currentURL);


                }
                currentURL = input;



            }
            if(!currentURL.equals("blank page"))
            System.out.println(currentURL);

            input = scanner.nextLine();
        }

    }
}
