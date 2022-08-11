package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        int newest = data.stream().mapToInt(Car::getYear).max().getAsInt();
        return data.stream().filter(y -> y.getYear() == newest).findFirst().orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(c -> c.getManufacturer().equals(manufacturer)).filter(m -> m.getModel()
                .equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        return "The cars are in a car dealership " + this.name + ":" + System.lineSeparator() +
                this.data.stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator()));
    }


}
