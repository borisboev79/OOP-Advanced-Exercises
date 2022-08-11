package Advanced.Advanced_Exercise6_DefiningClasses.ADV_EXS01_OpinionPoll;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < countOfPeople; i++) {
        String[] personInfo = scanner.nextLine().split(" ");
        Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
        people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

}
