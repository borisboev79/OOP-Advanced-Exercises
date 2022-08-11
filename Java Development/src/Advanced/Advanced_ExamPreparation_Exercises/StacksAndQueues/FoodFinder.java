package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> vowelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowelQueue.offer(e.charAt(0)));
        ArrayDeque<Character> consonantStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonantStack.push(e.charAt(0)));

        Map<String, Set<String>> foundWords = new LinkedHashMap<>();
        foundWords.put("pear", new HashSet<>());
        foundWords.put("flour", new HashSet<>());
        foundWords.put("pork", new HashSet<>());
        foundWords.put("olive", new HashSet<>());

        while (!consonantStack.isEmpty()) {

            String vowel = Objects.requireNonNull(vowelQueue.poll()).toString();
            String consonant = consonantStack.pop().toString();

            for (Map.Entry<String, Set<String>> entry : foundWords.entrySet()) {
                String word = entry.getKey();
                if (word.contains(vowel)) {
                    Set<String> val = foundWords.get(word);
                    val.add(vowel);
                    foundWords.put(word, val);
                }
                if (word.contains(consonant)) {
                    Set<String> val = foundWords.get(word);
                    val.add(consonant);
                    foundWords.put(word, val);
                }
            }
            vowelQueue.offer(vowel.charAt(0));
        }
        System.out.printf("Words found: %d%n", foundWords.entrySet().stream().filter(e -> e.getKey().length() == e.getValue().size()).count());
        foundWords.entrySet().stream().filter(e -> e.getKey().length() == e.getValue().size()).forEach(e -> System.out.println(e.getKey()));
   }
}



