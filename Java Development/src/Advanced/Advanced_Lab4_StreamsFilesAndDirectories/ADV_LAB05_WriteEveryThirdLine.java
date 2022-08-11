package Advanced.Advanced_Lab4_StreamsFilesAndDirectories;

import java.io.*;

public class ADV_LAB05_WriteEveryThirdLine {
    public static void main(String[] args) {
        String path = "C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        File output = new File("print-every-third-line.txt");
        try (BufferedReader in = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(new FileWriter(output))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);

                }
                counter++;
                line = in.readLine();

            }
        } catch(IOException ignored){
        }


    }
}
