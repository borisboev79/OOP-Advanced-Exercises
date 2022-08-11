package OOP.InterfacesAndAbstraction_Lab.L05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> database = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");

            Identifiable identifiable = data.length == 2
                    ? new Robot(data[0], data[1])
                    : new Citizen(data[0], Integer.parseInt(data[1]), data[2]);

            database.add(identifiable);

            input = scanner.nextLine();
        }
        String fakeIds = scanner.nextLine();

        database.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIds)).forEach(System.out::println);
    }
}
