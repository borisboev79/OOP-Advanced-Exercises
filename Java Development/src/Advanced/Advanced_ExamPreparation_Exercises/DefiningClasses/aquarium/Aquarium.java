package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.aquarium;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Aquarium {
    private Set<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {
        if (fishInPool.size() < getCapacity()) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if(fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        return "Aquarium: " + this.name + " ^ Size: " + this.size + System.lineSeparator() +
                this.fishInPool.stream().map(Fish::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    }

