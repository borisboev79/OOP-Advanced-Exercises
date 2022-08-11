package OOP.Inheritance_Exercise.E02_Zoo;

public class Main {
    public static void main(String[] args) {
        Lizard lizard = new Lizard("Lizard");
        Bear bear = new Bear("Bear");

        System.out.println(bear.getName());
        System.out.println(lizard.getName());
    }
}
