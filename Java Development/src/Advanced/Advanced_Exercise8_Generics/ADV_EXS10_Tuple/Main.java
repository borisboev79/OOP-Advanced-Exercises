package Advanced.Advanced_Exercise8_Generics.ADV_EXS10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String firstName = input[0];
        String secondName = input[1];
        String address = input[2];
        Tuple<String, String> tuple = new Tuple<>(firstName + " " + secondName, address);
        System.out.println(tuple);

        String[] input2 = scanner.nextLine().split(" ");
        String name = input2[0];
        int beerLitres = Integer.parseInt(input2[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(name, beerLitres);
        System.out.println(secondTuple);

        String[] input3 = scanner.nextLine().split(" ");
        int age = Integer.parseInt(input3[0]);
        double coordinates = Double.parseDouble(input3[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(age, coordinates);
        System.out.println(thirdTuple);
    }
}
