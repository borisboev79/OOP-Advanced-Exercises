package OOP.Inheritance_Lab.L03_HierarchicalInheritance;

import OOP.Inheritance_Lab.L02_MultipleInheritance.Puppy;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();

    }
}
