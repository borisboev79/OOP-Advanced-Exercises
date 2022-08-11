package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class ReVolt {

    private static int playerCurrentRow = -1;
    private static int playerCurrentCol = -1;

    private static int finishRow = -1;
    private static int finishCol = -1;

    private static int playerNextRow = -1;
    private static int playerNextCol = -1;

    private static boolean reachedFinish = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int commandCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {

            String line = scanner.nextLine();

            matrix[row] = line.toCharArray();


            if (line.contains("f")) {
                playerCurrentRow = row;
                playerCurrentCol = line.indexOf("f");

            } else if (line.contains("F")) {
                finishRow = row;
                finishCol = line.indexOf("F");
            }
        }

        for (int i = 0; i < commandCount; i++) {
            if(reachedFinish) {
                break;
            }
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
            }
        }
        if(reachedFinish) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        print2dArray(matrix);
    }

    private static void movePlayer(char[][] matrix, int r, int c) {

        playerNextRow = rowOutOfBoundsFix(matrix, playerCurrentRow + r);
        playerNextCol = colOutOfBoundsFix(matrix, playerCurrentCol + c);

        char playerNextPosition = matrix[playerNextRow][playerNextCol];

        if(playerNextPosition == 'F') {
            matrix[playerCurrentRow][playerCurrentCol] = '-';
            matrix[playerNextRow][playerNextCol] = 'f';
            reachedFinish = true;
            return;
        } else if (playerNextPosition == 'B') {
            matrix[playerCurrentRow][playerCurrentCol] = '-';
            playerCurrentRow = rowOutOfBoundsFix(matrix, playerNextRow + r);
            playerCurrentCol = colOutOfBoundsFix(matrix, playerNextCol + c);

            if(matrix[playerCurrentRow][playerCurrentCol] == 'F') {
                matrix[playerCurrentRow][playerCurrentCol] = 'f';
                reachedFinish = true;
            } else {
                matrix[playerCurrentRow][playerCurrentCol] = 'f';
            }
            return;

        } else if (playerNextPosition == 'T') {
            playerNextRow = rowOutOfBoundsFix(matrix, playerCurrentRow - r);
            playerNextCol = colOutOfBoundsFix(matrix, playerCurrentCol - c);
            return;

        }
        if(matrix[playerCurrentRow][playerCurrentCol] != 'B' && matrix[playerCurrentRow][playerCurrentCol] != 'T') {
            matrix[playerCurrentRow][playerCurrentCol] = '-';
        }
        playerCurrentRow = playerNextRow;
        playerCurrentCol = playerNextCol;
        matrix[playerNextRow][playerNextCol] = 'f';

    }

    private static int rowOutOfBoundsFix(char[][] matrix, int r) {
        if (r >= matrix.length) {
            return  0;
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
