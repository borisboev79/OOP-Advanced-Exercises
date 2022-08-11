package Advanced.Advanced_Exercise4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ADV_EXS07_MergeTwoFiles {
    public static void main(String[] args) {
        Path input1 = Paths.get("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path input2 = Paths.get("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path output = Paths.get("D:\\Java Exercises\\Output\\output.txt");
        try{
            List<String> firstFile = Files.readAllLines(input1);
            List<String> secondFile = Files.readAllLines(input2);
            Files.write(output, firstFile, StandardOpenOption.APPEND);
            Files.write(output, secondFile, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
