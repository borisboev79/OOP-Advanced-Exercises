package Advanced.Advanced_Exercise2_MultidimensionalArrays;

import java.util.Scanner;

public class ADV_EXS08_TheHeiganDance {

    private static int playerRow = 7;
    private static int playerCol = 7;
    private static int playerHealth = 18_500;
    private static boolean playerHitByPlague = false;

    private static double heiganHealth = 3_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double playerHitPoints = Double.parseDouble(scanner.nextLine());
        int[][] matrix = new int[15][15];
        String killerSpell = "";

        while (playerHealth > 0 && heiganHealth > 0) {
            heiganHealth -= playerHitPoints;

            if (playerHitByPlague) {
                playerHealth -= 3500;
                playerHitByPlague = false;
            }
            if (heiganHealth <= 0 || playerHealth <= 0) {
                break;
            }

            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            int damageRow = Integer.parseInt(data[1]);
            int damageCol = Integer.parseInt(data[2]);

            if ((playerRow >= damageRow - 1 && playerRow <= damageRow + 1) && (playerCol >= damageCol - 1 &&
                    playerCol <= damageCol + 1)) {
                if (playerRow - 1 >= 0 && playerRow - 1 < damageRow - 1) {
                    playerRow--;
                } else if (playerCol + 1 > damageCol + 1 && playerCol + 1 <= 14) {
                    playerCol++;
                } else if (playerRow + 1 > damageRow + 1 && playerRow + 1 <= 14) {
                    playerRow++;
                } else if (playerCol - 1 >= 0 && playerCol - 1 < damageCol - 1) {
                    playerCol--;
                } else if (heiganHealth > 0) {

                    switch (command) {
                        case "Cloud":
                            playerHitByPlague = true;
                            playerHealth -= 3500;
                            killerSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            killerSpell = "Eruption";
                            break;

                    }
                }
            }
        }
        if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }
        if (playerHealth <= 0) {
            System.out.println("Player: Killed by " + killerSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);

    }
}
