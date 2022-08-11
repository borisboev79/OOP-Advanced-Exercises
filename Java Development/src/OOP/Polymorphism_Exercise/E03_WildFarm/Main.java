package OOP.Polymorphism_Exercise.E03_WildFarm;

import OOP.Polymorphism_Exercise.E03_WildFarm.Animals.*;
import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Food;
import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Meat;
import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Vegetable;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Animal> animals = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"End".equals(input)) {

            String[] animalParts = input.split(" ");
            String animalType = animalParts[0];
            String animalName = animalParts[1];
            Double animalWeight = Double.parseDouble(animalParts[2]);
            String animalLivingRegion = animalParts[3];
            String catBreed = null;

            if (animalType.equals("Cat")) {
                catBreed = animalParts[4];
            }
            Food food = null;
            String[] foodParts = scanner.nextLine().split(" ");
            String foodType = foodParts[0];
            Integer foodQuantity = Integer.parseInt(foodParts[1]);
            switch (foodType) {
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;

            }

            switch (animalType) {
                case "Cat":
                    Animal cat = new Cat(animalName, animalType, animalWeight, foodQuantity, animalLivingRegion, catBreed);
                    cat.makeSound();
                    cat.eat(food);
                    animals.add(cat);
                    break;
                case "Tiger":
                    Animal tiger = new Tiger(animalName, animalType, animalWeight, foodQuantity, animalLivingRegion);
                    tiger.makeSound();
                    try {
                        tiger.eat(food);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    animals.add(tiger);
                    break;
                case "Mouse":
                    Animal mouse = new Mouse(animalName, animalType, animalWeight, foodQuantity, animalLivingRegion);
                    mouse.makeSound();
                    try {
                        mouse.eat(food);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    animals.add(mouse);

                    break;
                case "Zebra":
                    Animal zebra = new Zebra(animalName, animalType, animalWeight, foodQuantity, animalLivingRegion);
                    zebra.makeSound();
                    try {
                        zebra.eat(food);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    animals.add(zebra);

            }
            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);

    }
}
