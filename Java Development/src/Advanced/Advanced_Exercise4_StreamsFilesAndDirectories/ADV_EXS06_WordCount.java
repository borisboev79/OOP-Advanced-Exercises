package Advanced.Advanced_Exercise4_StreamsFilesAndDirectories;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ADV_EXS06_WordCount {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
             Scanner textScanner = new Scanner(new FileReader("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
             PrintWriter pw = new PrintWriter("D:\\Java Exercises\\Output\\output.txt")) {

            LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
            Arrays.stream(scan.nextLine().split("\\s+")).forEach(word -> wordMap.put(word, 0));

            while (textScanner.hasNext()) {
                String textInput = textScanner.next();
                if (wordMap.containsKey(textInput)) {
                    int occurences = wordMap.get(textInput);
                    occurences++;
                    wordMap.put(textInput, occurences);
                }
            }
           wordMap.entrySet().forEach(entry -> pw.printf("%s - %d%n", entry.getKey(), entry.getValue()));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
