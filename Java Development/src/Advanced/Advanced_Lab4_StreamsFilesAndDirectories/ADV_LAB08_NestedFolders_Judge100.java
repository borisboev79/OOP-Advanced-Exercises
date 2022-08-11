package Advanced.Advanced_Lab4_StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ADV_LAB08_NestedFolders_Judge100 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while(!dirs.isEmpty()){
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
              if(nestedFile.isDirectory()) {
                  dirs.offer(nestedFile);
              }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");


    }
}
