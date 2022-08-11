package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available = true;

    public Parrot(String name, String spieces) {
        this.name = name;
        this.species = spieces;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable(){
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", this.species, this.name);
    }
}
