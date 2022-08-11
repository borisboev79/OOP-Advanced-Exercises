package OOP.SOLID_Exercise.products;

public class Coke extends Drink implements Product{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    private static final double DENSITY = 0.6;

    public Coke(double milliliters) {
        super(DENSITY, milliliters);
    }

    public double getMilliliters() {
        return getMilliliters();
    }

    @Override
    public double getAmountOfCalories() {

        return (CALORIES_PER_100_GRAMS / 100) *  this.getMilliliters() * DENSITY;
    }
}
