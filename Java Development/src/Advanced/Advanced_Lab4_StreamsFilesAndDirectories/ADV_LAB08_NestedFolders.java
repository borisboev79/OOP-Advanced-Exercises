package Advanced.Advanced_Lab4_StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ADV_LAB08_NestedFolders {
    public static void main(String[] args) throws IOException {

        File root = new File("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        List<String> folders = Files.walk(root.toPath())
                .map(Path::toFile)
                .filter(File::isDirectory)
                .map(File::getName)
                .collect(Collectors.toList());

        folders.forEach(System.out::println);
        System.out.println(folders.size() + " folders");


    }
}
