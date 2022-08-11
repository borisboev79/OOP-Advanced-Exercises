package Advanced.Advanced_Lab4_StreamsFilesAndDirectories;

import java.io.*;

public class ADV_LAB09_SerializeCustomObject {


    public static void main(String[] args) {

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String path = "D:\\Java Exercises\\Output\\output.ser";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        }catch(FileNotFoundException e){
            System.out.println("ERROR! Cannot access destination folder " + e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;
    }
}
