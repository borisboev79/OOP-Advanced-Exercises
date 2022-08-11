package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //materials - stack
        //magic level - queue

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        ArrayDeque<Integer> magicLevel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> toys = new TreeMap<>();
        toys.put("Doll", 0);
        toys.put("Wooden train", 0);
        toys.put("Teddy bear", 0);
        toys.put("Bicycle", 0);


        while (!materials.isEmpty() && !magicLevel.isEmpty()) {

            int currentMagic = magicLevel.peek();
            int currentMaterial = materials.peek();
            int result = currentMagic * currentMaterial;

            if (result == 0) {

                if (currentMagic == 0 && currentMaterial == 0) {
                    magicLevel.poll();
                    materials.pop();
                    continue;
                } else if (currentMagic != 0 && currentMaterial == 0) {
                    materials.pop();
                    continue;
                } else {
                    magicLevel.poll();
                    continue;
                }
            }

            if (result < 0) {

                materials.push(magicLevel.poll() + materials.pop());

            } else {

                magicLevel.poll();
                materials.pop();

                String toy = null;

                switch (result) {

                    case 150:
                        toy = "Doll";
                        break;
                    case 250:
                        toy = "Wooden train";
                        break;
                    case 300:
                        toy = "Teddy bear";
                        break;
                    case 400:
                        toy = "Bicycle";
                        break;
                    default:
                        materials.push(currentMaterial + 15);
                        break;
                }
                if (toy != null) {
                    toys.put(toy, toys.get(toy) + 1);
                }
            }
        }

        if (presentsAreReady(toys)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            String remainingMaterials = materials.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Materials left: " + remainingMaterials);
        }
        if (!magicLevel.isEmpty()) {
            String remainingMagic = magicLevel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Magic left: " + remainingMagic);
        }

        toys.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

    }

    private static boolean presentsAreReady(Map<String, Integer> toys) {

        return (toys.get("Doll") > 0 && toys.get("Wooden train") > 0) || (toys.get("Teddy bear") > 0 && toys.get("Bicycle") > 0);

    }
}

