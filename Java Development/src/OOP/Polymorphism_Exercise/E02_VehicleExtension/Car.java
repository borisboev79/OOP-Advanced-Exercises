package OOP.Polymorphism_Exercise.E02_VehicleExtension;

public class Car extends BaseVehicle {

    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity, String vehicleType) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, tankCapacity, vehicleType);
    }
}
