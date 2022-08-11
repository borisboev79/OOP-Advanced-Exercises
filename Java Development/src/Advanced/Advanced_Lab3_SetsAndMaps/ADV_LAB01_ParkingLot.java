package Advanced.Advanced_Lab3_SetsAndMaps;

import java.util.*;

public class ADV_LAB01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String regPlate = tokens[1];

            if (direction.equals("IN")) {
                cars.add(regPlate);
            } else {
                cars.remove(regPlate);
            }
            input = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {

                System.out.println(car);
            }

        }
    }
}
