package Advanced.Advanced_Exercise4_StreamsFilesAndDirectories;

import java.io.*;

public class ADV_EXS03_AllCapitals {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))){
            PrintWriter pw = new PrintWriter(new FileWriter("D:\\Java Exercises\\Output\\output.txt"));
            br.lines().forEach(line -> pw.println(line.toUpperCase()));
            pw.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
