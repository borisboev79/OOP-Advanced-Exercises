package Advanced.Advanced_Exercise8_Generics.ADV_EXS01_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box box = new Box();
        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            box.add(element);
            System.out.println(box);
        }


    }
}
