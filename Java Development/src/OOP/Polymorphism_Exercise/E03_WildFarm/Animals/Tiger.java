package OOP.Polymorphism_Exercise.E03_WildFarm.Animals;

import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Food;
import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Meat;

public class Tiger extends Feline {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        setLivingRegion(livingRegion);
    }

    @Override
    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");

    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(getFoodEaten());
        } else {
            setFoodEaten(0);
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
