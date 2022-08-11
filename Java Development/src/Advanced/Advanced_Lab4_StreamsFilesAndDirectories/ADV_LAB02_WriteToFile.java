package Advanced.Advanced_Lab4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class ADV_LAB02_WriteToFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("output.txt");

            int read = inputStream.read();

            Set<Character> punctuations = Set.of(',', '.', '!', '?');

            while (read != -1) {

                if (!punctuations.contains((char) read)) {
                    outputStream.write(read);



                }
                read = inputStream.read();
            }
        } catch (IOException ignored) {
        }

    }
}
