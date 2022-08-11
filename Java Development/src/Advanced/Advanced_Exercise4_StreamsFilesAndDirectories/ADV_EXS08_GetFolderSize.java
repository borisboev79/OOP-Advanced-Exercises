package Advanced.Advanced_Exercise4_StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class ADV_EXS08_GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        Deque<File> files = new ArrayDeque<>();
        files.offer(folder);
        int totalSize = 0;
        while(!files.isEmpty()){
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile: nestedFiles) {
                if(nestedFile.isDirectory()){
                    files.offer(nestedFile);
                }else{
                    totalSize += nestedFile.length();
                }
            }
        }
        System.out.println("Folder size: "+ totalSize);
    }

}
