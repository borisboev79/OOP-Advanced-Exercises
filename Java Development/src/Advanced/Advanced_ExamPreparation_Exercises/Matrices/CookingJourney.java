package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;
public class CookingJourney {

    private static int chefRow = -1;
    private static int chefCol = -1;

    private static int pillar1Row = 0;
    private static int pillar1Col = 0;

    private static int pillar2Row = 0;
    private static int pillar2Col = 0;

    private static boolean isInMatrix = true;
    private static int moneySpent = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int pillarCount = 0;

        for (int row = 0; row < size; row++) {

            String line = scanner.nextLine();

            matrix[row] = line.toCharArray();

            if (line.contains("S")) {
                chefRow = row;
                chefCol = line.indexOf("S");
            }
            if (line.contains("P") && pillarCount < 2) {

                if (pillarCount == 1) {
                    pillar2Row = row;
                    pillar2Col = line.indexOf('P');
                    pillarCount++;
                }
                if (pillarCount == 0) {

                    pillar1Row = row;
                    pillar1Col = line.indexOf('P');
                    pillarCount++;
                }
            }
        }

        String command = scanner.nextLine();

        while (moneySpent < 50) {


            if (command.equals("up")) {
                moveChef(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveChef(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveChef(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveChef(matrix, 0, 1);
            }
            if (!isInMatrix) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            if (moneySpent >= 50) {
                break;
            } else {
                command = scanner.nextLine();
            }
        }
        if (isInMatrix) {
            System.out.println("Good news! You succeeded in collecting enough money!");

        }
        System.out.printf("Money: %d%n", moneySpent);

        print2dArray(matrix);
    }

    private static void moveChef(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = chefRow + rowMutator;
        int nextCol = chefCol + colMutator;


        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[chefRow][chefCol] = '-';
            isInMatrix = false;
            return;
        }

        char destination = matrix[nextRow][nextCol];

        if (destination == 'P') {

            matrix[chefRow][chefCol] = '-';
            matrix[nextRow][nextCol] = '-';

            if (nextRow == pillar1Row && nextCol == pillar1Col) {
                chefRow = pillar2Row;
                chefCol = pillar2Col;
                matrix[pillar2Row][pillar2Col] = 'S';
            } else {
                chefRow = pillar1Row;
                chefCol = pillar1Col;
                matrix[pillar1Row][pillar1Col] = 'S';
            }
            return;
        }

        if (Character.isDigit(destination)) {

            int moneyFromCustomer = Character.getNumericValue(destination);
            moneySpent += moneyFromCustomer;

        }
        matrix[chefRow][chefCol] = '-';
        chefRow = nextRow;
        chefCol = nextCol;
        matrix[chefRow][chefCol] = 'S';

    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void print2dArray(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
