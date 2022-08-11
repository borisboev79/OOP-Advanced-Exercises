package OOP.SOLID_Exercise.products;

public class Lemonade extends Drink implements Product{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    private static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
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
