package OOP.InterfacesAndAbstraction_Exercise.E03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Birthable> beings = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] commandParts = input.split("\\s+");
            String object = commandParts[0];

            switch (object) {
                case "Citizen":
                    Birthable citizen = new Citizen(commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3], commandParts[4]);
                    beings.add(citizen);
                    break;
                case "Pet":
                    Birthable pet = new Pet(commandParts[1], commandParts[2]);
                    beings.add(pet);
                    break;
               case "Robot":
                    Identifiable robot = new Robot(commandParts[2], commandParts[1]);
                    break;
            }
            input = scanner.nextLine();
        }
        String yearOfBirth = scanner.nextLine();

        beings.stream().map(Birthable::getBirthDate).filter(birthDate -> birthDate.endsWith(yearOfBirth)).forEach(System.out::println);


    }

}


