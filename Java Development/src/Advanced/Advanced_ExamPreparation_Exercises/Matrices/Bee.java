package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class Bee {

    private static int beeRow = -1;
    private static int beeCol = -1;

    private static boolean isInMatrix = true;
    private static int pollinatedFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {

            String line = scanner.nextLine();

            matrix[row] = line.toCharArray();

            if (line.contains("B")) {
                beeRow = row;
                beeCol = line.indexOf("B");
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if (command.equals("up")) {
                moveBee(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveBee(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveBee(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveBee(matrix, 0, 1);
            }
            if (!isInMatrix) {
                System.out.println("The bee got lost!");
                break;
            }
            command = scanner.nextLine();
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
        print2dArray(matrix);
    }

    private static void moveBee(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = beeRow + rowMutator;
        int nextCol = beeCol + colMutator;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[beeRow][beeCol] = '.';
            isInMatrix = false;
            return;
        }

        char destination = matrix[nextRow][nextCol];

        if (destination == 'O') {
            matrix[nextRow][nextCol] = '.';
            nextRow = nextRow + rowMutator;
            nextCol = nextCol + colMutator;
            destination = matrix[nextRow][nextCol];
        }
        if (destination == 'f') {
            pollinatedFlowers++;
        }
        matrix[beeRow][beeCol] = '.';
        beeRow = nextRow;
        beeCol = nextCol;
        matrix[beeRow][beeCol] = 'B';
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

