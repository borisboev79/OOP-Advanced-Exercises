package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        return data.stream().filter(n -> n.getName().equals(name)).filter(o -> o.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        return "The grooming salon has the following clients:" + System.lineSeparator() +
                this.data.stream().map(pet -> pet.getName() + " " + pet.getOwner()).collect(Collectors.joining(System.lineSeparator()));
    }


}
