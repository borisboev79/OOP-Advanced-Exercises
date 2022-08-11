package Advanced.Advanced_Exercise6_DefiningClasses.ADV_EXS06_PokemonTrainerTODO;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Trainer> trainerList = new LinkedHashMap<>();
        String inputLine;
        while (!"Tournament".equals(inputLine= console.nextLine())){
            String[] data = inputLine.split("\\s+");
            trainerList.putIfAbsent(data[0], new Trainer(data[0]));
            Trainer singleTrainer = trainerList.get(data[0]);
            singleTrainer.addPokemon(new Pokemon(data[1], data[2], Integer.parseInt(data[3])));
        }
        String element;
        while (!"End".equals(element= console.nextLine())){
            String finalElement = element;
            trainerList.values().forEach(s -> s.applyCommand(finalElement));
        }
        trainerList.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(System.out::println);
    }
}