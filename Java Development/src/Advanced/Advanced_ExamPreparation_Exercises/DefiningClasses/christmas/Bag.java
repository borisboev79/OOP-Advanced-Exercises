package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < getCapacity()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {

        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
//        Present maxWeight = null;
//
//        for (Present present : data) {
//            double max = Double.MIN_VALUE;
//
//            if (present.getWeight() > max) {
//                max = present.getWeight();
//                maxWeight = present;
//            }
//        }
//        return maxWeight;
    }

    public Present getPresent(String name) {
//        for (Present present : data) {
//            if(present.getName().equals(name)) {
//                return present;
//            }
//        }
//        return null;
        return this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        //NO NEED TO CAPITALIZE FIRST LETTER
//        StringBuilder sb = new StringBuilder();
//        sb.append(getColor().substring(0, 1).toUpperCase()).append(getColor().substring(1).toLowerCase()).append(" bag contains: ")
//                .append(System.lineSeparator());

            //MY CODE
      //  StringBuilder sb = new StringBuilder();
      //  sb.append(getColor()).append(" bag contains: ").append(System.lineSeparator());



//        for (Present present : this.data) {
//            sb.append(present.toString());
//            sb.append(System.lineSeparator());
//        }
//
//        return sb.toString();

           // КРАДЕНО ОТ ЕСПИНОЗА


        return this.color + " bag contains:" + System.lineSeparator() +
                this.data.stream().map(Present::toString).collect(Collectors.joining(System.lineSeparator()));


    }

}


