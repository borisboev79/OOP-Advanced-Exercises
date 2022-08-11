package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class ThroneConquering {

    private static int energy = 0;
    private static int parisCurrentRow = -1;
    private static int parisCurrentCol = -1;
    private static int helenRow = -1;
    private static int helenCol = -1;

    private static int parisNextRow = -1;
    private static int parisNextCol = -1;

    private static boolean parisAbducted = false;
    private static boolean isDead = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {

            String line = scanner.nextLine();

            matrix[row] = line.toCharArray();

            if (line.contains("P")) {
                parisCurrentRow = row;
                parisCurrentCol = line.indexOf("P");

            } else if (line.contains("H")) {
                helenRow = row;
                helenCol = line.indexOf("H");
            }
        }

        String line = scanner.nextLine();

        while (energy > 0) {

            String[] commands = line.split("\\s+");
            String direction = commands[0];
            int enemyRow = Integer.parseInt(commands[1]);
            int enemyCol = Integer.parseInt(commands[2]);
            matrix[enemyRow][enemyCol] = 'S';

            switch (direction) {
                case "up":
                    moveParis(matrix, -1, 0);
                    break;
                case "down":
                    moveParis(matrix, 1, 0);
                    break;
                case "left":
                    moveParis(matrix, 0, -1);
                    break;
                case "right":
                    moveParis(matrix, 0, 1);
                    break;
            }
            if (parisAbducted || isDead) {
                break;
            } else {
                line = scanner.nextLine();
            }
        }
        if (isDead) {
            System.out.printf("Paris died at %d;%d.%n", parisNextRow, parisNextCol);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);

        }
        print2dArray(matrix);
    }

    private static void moveParis(char[][] matrix, int r, int c) {

        parisNextRow = parisCurrentRow + r;
        parisNextCol = parisCurrentCol + c;

        if (parisNextRow == helenRow && parisNextCol == helenCol) {
            matrix[helenRow][helenCol] = '-';
            matrix[parisCurrentRow][parisCurrentCol] = '-';
            energy--;
            parisAbducted = true;
            return;
        }
        if (isInBounds(matrix, parisNextRow, parisNextCol)) {

            if (matrix[parisNextRow][parisNextCol] == 'S') {
                energy -= 3;
            } else {
               energy--;
            }
            matrix[parisCurrentRow][parisCurrentCol] = '-';
            matrix[parisNextRow][parisNextCol] = 'P';
            parisCurrentRow = parisNextRow;
            parisCurrentCol = parisNextCol;

        } else {
            energy--;

        }

        if (energy <= 0) {
            if(isInBounds(matrix, parisNextRow, parisNextCol)) {
                matrix[parisNextRow][parisNextCol] = 'X';
            } else {
               matrix[parisCurrentRow][parisCurrentCol] = 'X';
               parisNextCol = parisCurrentCol;
               parisNextRow = parisCurrentRow;
            }
            isDead = true;
        }
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
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
