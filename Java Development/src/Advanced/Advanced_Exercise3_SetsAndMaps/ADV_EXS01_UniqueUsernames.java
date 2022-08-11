package Advanced.Advanced_Exercise3_SetsAndMaps;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ADV_EXS01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = "";
        Set<String> words = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            words.add(input);
        }
        for (String word : words
             ) {
            System.out.println(word);
        }
    }
}
