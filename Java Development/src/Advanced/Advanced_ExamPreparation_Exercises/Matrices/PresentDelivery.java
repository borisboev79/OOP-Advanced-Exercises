package Advanced.Advanced_ExamPreparation_Exercises.Matrices;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PresentDelivery {

    public static class Direction{
        private int row;
        private int col;

        public Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    private static int santaRow = 0;
    private static int santaCol = 0;
    private static int givenPresents = 0;
    private static int remainingPresents = 0;
    private static boolean santaIsInMatrix = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        remainingPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {

            String line = scanner.nextLine().replace(" ", "");

            matrix[row] = line.toCharArray();

            if (line.contains("S")) {
                santaRow = row;
                santaCol = line.indexOf("S");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning") && remainingPresents > 0) {

            if (command.equals("up")) {
                moveSanta(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveSanta(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveSanta(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveSanta(matrix, 0, 1);
            }
            if (!santaIsInMatrix || remainingPresents == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }

            command = scanner.nextLine();
        }

//        if (remainingPresents <= 0) {
//            System.out.println("Santa ran out of presents!");
//        }

        print2dArray(matrix);

//        if (remainingPresents <= 0) {
//            System.out.printf("Good job, Santa! %d happy nice kid/s.", //givenPresents);
//    }

        int unhappyKidsCount = 0;

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'V') {
                    unhappyKidsCount++;
                }
            }
        }
        if (unhappyKidsCount == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", givenPresents);
        } else {
            System.out.printf("No presents for %d nice kid/s.", unhappyKidsCount);
        }

    }

    private static void moveSanta(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = santaRow + rowMutator;
        int nextCol = santaCol + colMutator;

        boolean isCookieHit = false;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[santaRow][santaCol] = '-';
            santaIsInMatrix = false;
            return;
        }

        if (matrix[nextRow][nextCol] == 'V') {
            givenPresents++;
            remainingPresents--;
            matrix[nextRow][nextCol] = '-';

        } else if (matrix[nextRow][nextCol] == 'C') {
            isCookieHit = true;
        }

        if (matrix[santaRow][santaCol] != 'X') {

            matrix[santaRow][santaCol] = '-';
        }
        matrix[nextRow][nextCol] = 'S';
        santaRow = nextRow;
        santaCol = nextCol;

        if (isCookieHit) {

            List<Direction> directions = new ArrayList<>();

            directions.add(new Direction(nextRow - 1, nextCol));
            directions.add(new Direction(nextRow + 1, nextCol));
            directions.add(new Direction(nextRow, nextCol - 1));
            directions.add(new Direction(nextRow, nextCol + 1));

            for (Direction direction : directions) {
                //            if(isInBounds(matrix, direction.getRow(), direction.getCol())) {

                givePresents(matrix, direction.getRow(), direction.getCol());
                matrix[direction.getRow()][direction.getCol()] = '-';
                if (remainingPresents == 0) {
                    return;
                }

                //     }
            }
        }
    }

    private static void givePresents(char[][] matrix, int r, int c) {
        char position = matrix[r][c];
        if (position == 'V' || position == 'X') {
            givenPresents++;
            remainingPresents--;
        }
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void print2dArray(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}

