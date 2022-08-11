package OOP.Polymorphism_Exercise.E03_WildFarm.Animals;

import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Food;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");

    }

    @Override
    public void eat(Food food) {
        setFoodEaten(food.getQuantity());

    }

    @Override
    public String toString() {
        String df = new DecimalFormat("###.##").format(getAnimalWeight());
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), getBreed(), df, getLivingRegion(), getFoodEaten());
    }
}
