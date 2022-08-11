package Advanced.Advanced_Exercise3_SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ADV_EXS04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> symbolMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(!symbolMap.containsKey(currentChar)){
                symbolMap.put(currentChar, 1);
            } else{
                int currentCharCount = symbolMap.get(currentChar);

                symbolMap.put(currentChar, ++currentCharCount);
            }

        }
        // for(var pair : symbolMap.entrySet())

        for(Map.Entry<Character, Integer> pair : symbolMap.entrySet()){
            System.out.printf("%c: %d time/s%n", pair.getKey(), pair.getValue());
        }
    }
}

