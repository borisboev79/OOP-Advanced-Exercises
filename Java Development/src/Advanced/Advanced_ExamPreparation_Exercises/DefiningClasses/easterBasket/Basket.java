package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {

        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {

        return this.data.stream().max(Comparator.comparingDouble(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {

        return this.data.stream().filter(p -> p.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {

        return this.material + " basket contains:" + System.lineSeparator() +
                this.data.stream().map(Egg::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
