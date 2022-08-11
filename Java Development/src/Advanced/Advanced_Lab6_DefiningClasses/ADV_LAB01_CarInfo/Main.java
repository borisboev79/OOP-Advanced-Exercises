package Advanced.Advanced_Lab6_DefiningClasses.ADV_LAB01_CarInfo;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] cars = scanner.nextLine().split("\\s+");
            String brand = cars[0];
            String model = cars[1];
            int horsePower = Integer.parseInt(cars[2]);
            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            System.out.println(car.carInfo());
        }

    }
}
