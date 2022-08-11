package Advanced.Advanced_Lab1_StacksAndQueues;

import java.util.Scanner;
import java.util.ArrayDeque;

public class ADV_LAB01_BrowserHistory {
    public static void main(String[] args) {
        ArrayDeque<String> history = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentURL = "blank page";

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if(!history.isEmpty()){
                    currentURL = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                if(!currentURL.equals("blank page")){
                    history.push(currentURL);
                }
                currentURL = input;

            }
            System.out.println(currentURL);

            input = scanner.nextLine();
        }

    }

}


