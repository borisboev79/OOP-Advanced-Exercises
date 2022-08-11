package OOP.WorkingWithAbstraction_Exercise.E06_GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < items.length; i += 2) {
            String item = items[i];
            long quantity = Long.parseLong(items[i + 1]);
            bag.dispatch(item, quantity);
        }
        bag.getTreasure().printTreasures();
    }
}