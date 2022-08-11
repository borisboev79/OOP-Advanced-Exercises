package Advanced.Advanced_Lab1_StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;
public class ADV_LAB04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<Integer> openIndexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);

            if(currentSymbol == '('){
                openIndexes.push(i);


            } else if (currentSymbol == ')'){
                int startIndex = openIndexes.pop();
                String brackets = expression.substring(startIndex, i + 1);
                System.out.println(brackets);
            }

        }
    }
}
