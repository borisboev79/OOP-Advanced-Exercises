package OOP.Inheritance_Exercise.E06_Animals;

public class Kitten extends Cat {

    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound(){
        return "Meow";
    }
}
