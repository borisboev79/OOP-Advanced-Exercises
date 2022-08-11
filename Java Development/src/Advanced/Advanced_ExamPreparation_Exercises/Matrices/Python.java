package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class Python {

    private static int pythonCurrentRow = -1;
    private static int pythonCurrentCol = -1;

    private static int pythonNextRow = -1;
    private static int pythonNextCol = -1;

    private static int pythonLength = 1;
    private static int remainingFood = 0;
    private static boolean eatenAllFood = false;
    private static boolean isDead = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine().replace(" ", "");
            matrix[row] = line.toCharArray();

            if (line.contains("s")) {
                pythonCurrentRow = row;
                pythonCurrentCol = line.indexOf("s");
            }
            if (line.contains("f")) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'f') {
                        remainingFood++;
                    }
                }
            }
        }

        for (String command : commands) {
            switch (command) {
                case "up":
                    movePython(matrix, -1, 0);
                    break;
                case "down":
                    movePython(matrix, 1, 0);
                    break;
                case "left":
                    movePython(matrix, 0, -1);
                    break;
                case "right":
                    movePython(matrix, 0, 1);
                    break;
            }
        }

        if (remainingFood == 0) {
            System.out.println("You win! Final python length is " + pythonLength);
        } else if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", remainingFood);
        }

    }

    private static void movePython(char[][] matrix, int r, int c) {

        pythonNextRow = rowOutOfBoundsFix(matrix, pythonCurrentRow + r);
        pythonNextCol = colOutOfBoundsFix(matrix, pythonCurrentCol + c);

        char pythonNextPosition = matrix[pythonNextRow][pythonNextCol];

        if (pythonNextPosition == 'f') {
            pythonLength++;
            remainingFood--;
        } else if (pythonNextPosition == 'e') {
            isDead = true;
            return;
        }
        matrix[pythonCurrentRow][pythonCurrentCol] = '*';
        pythonCurrentRow = pythonNextRow;
        pythonCurrentCol = pythonNextCol;
        matrix[pythonNextRow][pythonNextCol] = 's';

    }

    private static int rowOutOfBoundsFix(char[][] matrix, int r) {
        if (r >= matrix.length) {
            return 0;
        }
        if (r < 0) {
            return matrix.length - 1;
        }
        return r;
    }

    private static int colOutOfBoundsFix(char[][] matrix, int c) {
        if (c >= matrix.length) {
            return 0;
        }
        if (c < 0) {
            return matrix.length - 1;
        }
        return c;
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
