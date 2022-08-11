package Advanced.Advanced_Exercise8_Generics.ADV_EXS04_GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box();
        for (int i = 0; i < n; i++) {
            Integer element = Integer.parseInt(scanner.nextLine());
            box.add(element);
        }
        int[] indecesToSwap = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = indecesToSwap[0];
        int secondIndex = indecesToSwap[1];

        box.swap(firstIndex, secondIndex);
        System.out.println(box);


    }
}
