package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class Snake {

    private static int snakeRow = -1;
    private static int snakeCol = -1;

    private static int burrow1Row = 0;
    private static int burrow1Col = 0;

    private static int burrow2Row = 0;
    private static int burrow2Col = 0;

    private static boolean isInMatrix = true;
    private static int eatenFood = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int burrowCount = 0;

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("S")) {
                snakeRow = row;
                snakeCol = line.indexOf("S");
            }
            if (line.contains("B") && burrowCount < 2) {

                if (burrowCount == 1) {
                    burrow2Row = row;
                    burrow2Col = line.indexOf('B');
                    burrowCount++;
                }
                if (burrowCount == 0) {

                    burrow1Row = row;
                    burrow1Col = line.indexOf('B');
                    burrowCount++;
                }
            }
        }

        String command = scanner.nextLine();

        while (eatenFood < 10) {

            if (command.equals("up")) {
                moveSnake(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveSnake(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveSnake(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveSnake(matrix, 0, 1);
            }
            if (!isInMatrix) {
                System.out.println("Game over!");
                break;
            }

            if (eatenFood >= 10) {
                break;
            } else {
                command = scanner.nextLine();
            }
        }
        if (isInMatrix) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", eatenFood);

        print2dArray(matrix);
    }

    private static void moveSnake(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = snakeRow + rowMutator;
        int nextCol = snakeCol + colMutator;


        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[snakeRow][snakeCol] = '.';
            isInMatrix = false;
            return;
        }

        char destination = matrix[nextRow][nextCol];

        if (destination == 'B') {

            matrix[snakeRow][snakeCol] = '.';
            matrix[nextRow][nextCol] = '.';

            if (nextRow == burrow1Row && nextCol == burrow1Col) {
                snakeRow = burrow2Row;
                snakeCol = burrow2Col;
                matrix[burrow2Row][burrow2Col] = 'S';
            } else {
                snakeRow = burrow1Row;
                snakeCol = burrow1Col;
                matrix[burrow1Row][burrow1Col] = 'S';
            }
            return;

        }
        if (destination == '*') {
            eatenFood++;

        }

        matrix[snakeRow][snakeCol] = '.';
        snakeRow = nextRow;
        snakeCol = nextCol;
        matrix[snakeRow][snakeCol] = 'S';

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
