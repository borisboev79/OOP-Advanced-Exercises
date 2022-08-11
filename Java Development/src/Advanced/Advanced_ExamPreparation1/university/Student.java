package Advanced.Advanced_ExamPreparation1.university;

public class Student {
    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    @Override
    public String toString() {
        return "StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.Student: " + firstName + " " + lastName + ", " + bestSubject;
    }
}
