package Advanced.Advanced_Exercise4_StreamsFilesAndDirectories;

import java.io.*;

public class ADV_EXS11_SerializeCustomObject {
    public static void main(String[] args) {
        Course course = new Course();
        course.name = "Java Advanced";
        course.numberOfStudents = 250;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Java Exercises\\Output\\course.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Java Exercises\\Output\\course.ser"))) {
            oos.writeObject(course);

            Course courseFromFile = (Course) ois.readObject();
            System.out.println(courseFromFile.name);
            System.out.println(courseFromFile.numberOfStudents);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        static class Course implements Serializable {
        String name;
        int numberOfStudents;
    }
}
