package Advanced.Advanced_Lab4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ADV_LAB01_ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            int read = inputStream.read();

            while(read != -1){
                System.out.print(Integer.toBinaryString(read) + " ");

                read = inputStream.read();
            }
        } catch(IOException ignored) {
        }

    }
}
