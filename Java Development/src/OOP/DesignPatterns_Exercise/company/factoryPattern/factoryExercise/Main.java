package OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise;
import OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise.Cakes.Cake;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cakeType = scanner.nextLine();
        Cake cake = PastryShop.deliverCake(cakeType);

    }
}
