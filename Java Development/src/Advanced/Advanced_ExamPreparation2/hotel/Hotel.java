package Advanced.Advanced_ExamPreparation2.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream().filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics() {

       return "The people in the hotel " + this.name + " are:" + System.lineSeparator() +
                    this.roster.stream().map(Person::toString).collect(Collectors.joining(System.lineSeparator()));

    }

}
