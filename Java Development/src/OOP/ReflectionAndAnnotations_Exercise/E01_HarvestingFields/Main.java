package OOP.ReflectionAndAnnotations_Exercise.E01_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Class reflection = RichSoilLand.class;
        Field[] fields = reflection.getDeclaredFields();

        while (!"HARVEST".equals(input)) {

            switch (input) {

                case "protected":
                    Arrays.stream(fields).filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(f -> System.out.printf("protected %s %s%n", f.getType().getSimpleName(), f.getName()));
                    break;
                case "private":
                    Arrays.stream(fields).filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f -> System.out.printf("private %s %s%n", f.getType().getSimpleName(), f.getName()));
                    break;
                case "public":
                    Arrays.stream(fields).filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(f -> System.out.printf("public %s %s%n", f.getType().getSimpleName(), f.getName()));
                    break;
                case "all":
                    printAllFields(fields);

            }
            input = scanner.nextLine();
        }
        scanner.close();
    }

    private static void printAllFields(Field[] fields) {

        for (Field field : fields) {
            String modifier = null;

            if (Modifier.isProtected(field.getModifiers())) {
                modifier = "protected";
            } else if (Modifier.isPrivate(field.getModifiers())) {
                modifier = "private";
            } else if (Modifier.isPublic(field.getModifiers())) {
                modifier = "public";
            }
            System.out.printf("%s %s %s%n", modifier, field.getType().getSimpleName(), field.getName());
        }
    }
}

