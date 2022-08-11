package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class Selling {

    private static int sellerRow = -1;
    private static int sellerCol = -1;

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
                sellerRow = row;
                sellerCol = line.indexOf("S");
            }
            if (line.contains("O") && pillarCount < 2) {

                if (pillarCount == 1) {
                    pillar2Row = row;
                    pillar2Col = line.indexOf('O');
                    pillarCount++;
                }
                if (pillarCount == 0) {

                    pillar1Row = row;
                    pillar1Col = line.indexOf('O');
                    pillarCount++;
                }
            }
        }

        String command = scanner.nextLine();

        while (moneySpent < 50) {


            if (command.equals("up")) {
                moveSeller(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveSeller(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveSeller(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveSeller(matrix, 0, 1);
            }
            if (!isInMatrix) {
                System.out.println("Bad news, you are out of the bakery.");
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

    private static void moveSeller(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = sellerRow + rowMutator;
        int nextCol = sellerCol + colMutator;


        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[sellerRow][sellerCol] = '-';
            isInMatrix = false;
            return;
        }

        char destination = matrix[nextRow][nextCol];

        if (destination == 'O') {

            matrix[sellerRow][sellerCol] = '-';
            matrix[nextRow][nextCol] = '-';

            if (nextRow == pillar1Row && nextCol == pillar1Col) {
                sellerRow = pillar2Row;
                sellerCol = pillar2Col;
                matrix[pillar2Row][pillar2Col] = 'S';
            } else {
                sellerRow = pillar1Row;
                sellerCol = pillar1Col;
                matrix[pillar1Row][pillar1Col] = 'S';
            }
            return;
        }

        if (Character.isDigit(destination)) {

            int moneyFromCustomer = Character.getNumericValue(destination);
            moneySpent += moneyFromCustomer;

        }
        matrix[sellerRow][sellerCol] = '-';
        sellerRow = nextRow;
        sellerCol = nextCol;
        matrix[sellerRow][sellerCol] = 'S';

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
