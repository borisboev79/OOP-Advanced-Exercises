package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class Armory {

    private static int officerRow = -1;
    private static int officerCol = -1;

    private static int mirror1Row = 0;
    private static int mirror1Col = 0;

    private static int mirror2Row = 0;
    private static int mirror2Col = 0;

    private static boolean isInMatrix = true;
    private static int moneySpent = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int mirrorCount = 0;

        for (int row = 0; row < size; row++) {

            String line = scanner.nextLine();

            matrix[row] = line.toCharArray();

            if (line.contains("A")) {
                officerRow = row;
                officerCol = line.indexOf("A");
            }
            if (line.contains("M") && mirrorCount < 2) {

                if (mirrorCount == 1) {
                    mirror2Row = row;
                    mirror2Col = line.indexOf('M');
                    mirrorCount++;
                }
                if (mirrorCount == 0) {

                    mirror1Row = row;
                    mirror1Col = line.indexOf('M');
                    mirrorCount++;
                }
            }
        }

        String command = scanner.nextLine();

        while (moneySpent < 65) {


            if (command.equals("up")) {
                moveOfficer(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveOfficer(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveOfficer(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveOfficer(matrix, 0, 1);
            }
            if (!isInMatrix) {
                System.out.println("I do not need more swords!");
                break;
            }

            if (moneySpent >= 65) {
                break;
            } else {
                command = scanner.nextLine();
            }
        }
        if (isInMatrix) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", moneySpent);

        print2dArray(matrix);
    }

    private static void moveOfficer(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = officerRow + rowMutator;
        int nextCol = officerCol + colMutator;


        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[officerRow][officerCol] = '-';
            isInMatrix = false;
            return;
        }

        char destination = matrix[nextRow][nextCol];

        if (destination == 'M') {

            matrix[officerRow][officerCol] = '-';
            matrix[nextRow][nextCol] = '-';

            if (nextRow == mirror1Row && nextCol == mirror1Col) {
                officerRow = mirror2Row;
                officerCol = mirror2Col;
                matrix[mirror2Row][mirror2Col] = 'A';
            } else {
                officerRow = mirror1Row;
                officerCol = mirror1Col;
                matrix[mirror1Row][mirror1Col] = 'A';
            }
            return;
        }

        if (Character.isDigit(destination)) {

            int swordPrice = Character.getNumericValue(destination);
            moneySpent += swordPrice;

        }
        matrix[officerRow][officerCol] = '-';
        officerRow = nextRow;
        officerCol = nextCol;
        matrix[officerRow][officerCol] = 'A';

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
