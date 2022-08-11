package Advanced.Advanced_Lab3_SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ADV_LAB03_VoinaNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 0;
        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            rounds++;
            if (rounds == 50) {
                break;
            }
            int firstCard = firstDeck.iterator().next();
            firstDeck.remove(firstCard);

            int secondCard = secondDeck.iterator().next();
            secondDeck.remove(secondCard);

            if(firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if(secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }
        if(firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        }else if(secondDeck.size() > firstDeck.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
