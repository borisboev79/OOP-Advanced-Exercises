package OOP.Polymorphism_Exercise.E02_VehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        buildVehicle(scanner);
        buildVehicle(scanner);
        buildVehicle(scanner);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            executeCommand(scanner);
        }
        vehicles.values().forEach(System.out::println);

    }

    private static void buildVehicle(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        String vehicleType = input[0];
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelConsumption = Double.parseDouble(input[2]);
        double tankCapacity = Double.parseDouble(input[3]);

        switch (vehicleType) {

            case "Car":
                Vehicle car = new Car(fuelQuantity, fuelConsumption, tankCapacity, vehicleType);
                vehicles.put(input[0], car);
                break;
            case "Truck":
                Vehicle truck = new Truck(fuelQuantity, fuelConsumption, tankCapacity, vehicleType);
                vehicles.put(input[0], truck);
                break;
            case "Bus":
                Vehicle bus = new Bus(fuelQuantity, fuelConsumption, tankCapacity, vehicleType);
                vehicles.put(input[0], bus);
                break;
        }
    }

    private static void executeCommand(Scanner scanner) {
        String[] commands = scanner.nextLine().split("\\s+");
        String command = commands[0];
        String vehicleType = commands[1];

        switch (command) {

            case "Drive":
                double kilometers = Double.parseDouble(commands[2]);
                System.out.println(vehicles.get(vehicleType).drive(kilometers));
                break;
            case "DriveEmpty":
                kilometers = Double.parseDouble(commands[2]);
                if (vehicles.get(vehicleType) instanceof Bus bus) {
                    System.out.println(bus.driveEmpty(kilometers));
                }
                break;
            case "Refuel":
                try {
                    double litres = Double.parseDouble(commands[2]);
                    vehicles.get(vehicleType).refuel(litres);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }

}
