package Advanced.Advanced_Lab1_StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;
public class ADV_LAB02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> calculator = new ArrayDeque<>();
        for (int i = input.length - 1 ; i >= 0; i--) {
            calculator.push(input[i]);
        }
        while(calculator.size() != 1){
            int firstNum = Integer.parseInt(calculator.pop());
            String operator = calculator.pop();
            int secondtNum = Integer.parseInt(calculator.pop());
            int result = 0;
            if(operator.equals("+")) {
                result = firstNum + secondtNum;
            }else{
                result = firstNum - secondtNum;
            }
            calculator.push(String.valueOf(result));
        }

        System.out.println(calculator.pop());
    }

}
