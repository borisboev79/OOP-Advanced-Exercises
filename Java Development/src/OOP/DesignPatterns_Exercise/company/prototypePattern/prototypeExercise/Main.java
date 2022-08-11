package OOP.DesignPatterns_Exercise.company.prototypePattern.prototypeExercise;

public class Main {
    public static void main(String[] args) {
        EmployeeRecord pesho = new EmployeeRecord(2, "pesho", "more", 150, "Sofia");
        Prototype pesho1 = pesho.getClone();
        pesho.showRecord();
        EmployeeRecord gosho = new EmployeeRecord();
        gosho.showRecord();
    }
}
