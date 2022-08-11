package OOP.Polymorphism_Exercise.E03_WildFarm.Animals;

import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Food;
import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Vegetable;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten());
        } else {
            setFoodEaten(0);
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
    }

