package Advanced.Advanced_Exercise6_DefiningClasses.ADV_EXS07_GoogleTODO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Person> personList = new HashMap<>();
        String inputLine;
        while (!"End".equals(inputLine = console.nextLine())) {
            String[] data = inputLine.split("\\s+");
            String name = data[0];
            personList.putIfAbsent(name, new Person(name));
            Person singlePerson = personList.get(name);
            switch (data[1]) {
                case "company":
                    singlePerson.setCompany(new Company(data[2], data[3], Double.parseDouble(data[4])));
                    break;
                case "car":
                    singlePerson.setCar(new Car(data[2], Integer.parseInt(data[3])));
                    break;
                case "pokemon":
                    singlePerson.addPokemon(new Pokemon(data[2], data[3]));
                    break;
                case "parents":
                    singlePerson.addParent(new Parent(data[2], data[3]));
                    break;
                case "children":
                    singlePerson.addChild(new Children(data[2], data[3]));
                    break;
            }
        }
        System.out.println(personList.get(console.nextLine()));
    }
}
