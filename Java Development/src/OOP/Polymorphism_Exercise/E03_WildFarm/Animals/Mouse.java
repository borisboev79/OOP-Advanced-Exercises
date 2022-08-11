package OOP.Polymorphism_Exercise.E03_WildFarm.Animals;

import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Food;
import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Vegetable;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
            if (food instanceof Vegetable) {
                setFoodEaten(getFoodEaten());
            } else {
                setFoodEaten(0);
                throw new IllegalArgumentException("Mice are not eating that type of food!");
            }
        }

    }

