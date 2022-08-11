package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if(parrot.getName().equals(name)) {
               this.data.remove(parrot);
               return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
       Parrot parrot = this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
       parrot.setAvailable(false);
       return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {

        List<Parrot> soldParrots = this.data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());
        soldParrots.forEach(p -> this.data.remove(p));

        return soldParrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {

        return "Parrots available at " + this.name + ":" + System.lineSeparator() +
                this.data.stream().filter(Parrot::isAvailable).map(Parrot::toString).collect(Collectors.joining(System.lineSeparator()));
    }

}
