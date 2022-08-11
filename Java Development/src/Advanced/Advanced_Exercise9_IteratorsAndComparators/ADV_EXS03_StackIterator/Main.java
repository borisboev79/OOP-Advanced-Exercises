package Advanced.Advanced_Exercise9_IteratorsAndComparators.ADV_EXS03_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String command;
        Stack current = new Stack();
        while (!"END".equals(command = console.nextLine())) {
            String[] data = command.split("\\s+|,\\s+");
            switch (data[0]) {
                case "Push":
                    current.push(Arrays.copyOfRange(data, 1, data.length));
                    break;
                case "Pop":
                    try {
                        current.pop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        Stack.print(current);
        Stack.print(current);
    }
}