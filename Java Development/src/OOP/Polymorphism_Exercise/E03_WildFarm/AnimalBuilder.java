package OOP.Polymorphism_Exercise.E03_WildFarm;

import OOP.Polymorphism_Exercise.E03_WildFarm.Animals.Animal;

import java.util.Scanner;

public abstract class AnimalBuilder {
    private static Animal animal;


    public AnimalBuilder(Animal animal) {
        this.animal = animal;
    }

    public static Animal getAnimal(Scanner scanner) {

        String input = scanner.nextLine();
        String[] animalParts = input.split("\\s+");

        String type = animalParts[0];
        String name = animalParts[1];
        Double weight = Double.parseDouble(animalParts[2]);
        String livingRegion = animalParts[3];
        String breed = null;

        if (type.equals("Cat")) {
            breed = animalParts[4];
        }


        switch (type) {
            case "Cat":
            //    animal = new Cat(name, type, weight, livingRegion, breed);


        }

        return animal;
    }

}
