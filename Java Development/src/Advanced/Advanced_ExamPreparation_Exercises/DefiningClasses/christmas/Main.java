package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.christmas;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        Bag bag = new Bag("black", 10);

// Initialize entity
        Present present = new Present("Doll", 0.4, "girl");

// Print Present
        System.out.println(present); // Present Doll (0.40) for a girl

// Add Present
        bag.add(present);

// Remove Present
        bag.remove("Toy"); // false

        Present secondPresent = new Present("Train", 2, "boy");

        // Add Present
        bag.add(secondPresent);

        Present thirdPresent = new Present("Wall-E", 4.5, "boy");
        bag.add(thirdPresent);

        Present heaviestPresent = bag.heaviestPresent();
        System.out.println(heaviestPresent);
// Present Train (2.00) for a boy

        Present p = bag.getPresent("Doll");
        System.out.println(p);
// Present Doll (0.40) for a girl

     System.out.println(bag.count()); // 2
     System.out.println(bag.report());

// Black bag contains:
// Present Doll (0.40) for a girl
// Present Train (2.00) for a boy





    }
}
