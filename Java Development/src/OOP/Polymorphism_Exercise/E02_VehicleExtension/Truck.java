package OOP.Polymorphism_Exercise.E02_VehicleExtension;

public class Truck extends BaseVehicle {

    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;


    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity, String vehicleType) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, tankCapacity, vehicleType);
    }

    @Override
    public void refuel(double litres) {
        if (litres <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (litres + getFuelQuantity() > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        setFuelQuantity(getFuelQuantity() + litres * 0.95);
    }
}
