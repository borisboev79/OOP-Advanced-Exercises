package OOP.Polymorphism_Exercise.E03_WildFarm.Animals;

import OOP.Polymorphism_Exercise.E03_WildFarm.Foods.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food){
        setFoodEaten(getFoodEaten());
    };

    @Override
    public String toString() {
        String df = new DecimalFormat("###0.##").format(getAnimalWeight());
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(), df, getLivingRegion(), getFoodEaten());
    }
}
