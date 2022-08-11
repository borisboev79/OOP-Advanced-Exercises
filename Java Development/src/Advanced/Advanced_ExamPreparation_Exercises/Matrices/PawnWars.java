package Advanced.Advanced_ExamPreparation_Exercises.Matrices;

import java.util.Scanner;

public class PawnWars {

    private static int whiteCurrentRow = -1;
    private static int whiteCurrentCol = -1;
    private static int blackCurrentRow = -1;
    private static int blackCurrentCol = -1;
    private static boolean pawnCapture = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
          char[][] matrix = new char[8][8];

        for (int row = 0; row < 8; row++) {

            String line = scanner.nextLine();

            matrix[row] = line.toCharArray();

            if (line.contains("w")) {
                whiteCurrentRow = row;
                whiteCurrentCol = line.indexOf("w");

            } else if (line.contains("b")) {
                blackCurrentRow = row;
                blackCurrentCol = line.indexOf("b");
            }
        }

        String winner = null;
        String position = null;

        while (whiteCurrentRow > 0 && blackCurrentRow < 7) {

            if (!doesCapture(whiteCurrentRow, whiteCurrentCol, blackCurrentRow, blackCurrentCol)) {
                matrix[whiteCurrentRow][whiteCurrentCol] = '-';
                whiteCurrentRow--;
                matrix[whiteCurrentRow][whiteCurrentCol] = 'w';
            } else {
                winner = "White";
                break;
            }

            if (!doesCapture(whiteCurrentRow, whiteCurrentCol, blackCurrentRow, blackCurrentCol)) {
                matrix[blackCurrentRow][blackCurrentCol] = '-';
                blackCurrentRow++;
                matrix[blackCurrentRow][blackCurrentCol] = 'b';
            } else {
                winner = "Black";
                break;
            }

        }
        if (pawnCapture) {
            if (winner.equals("White")) {
                position = getPosition(blackCurrentRow, blackCurrentCol);
            } else {
                position = getPosition(whiteCurrentRow, whiteCurrentCol);
            }
            System.out.printf("Game over! %s capture on %s.", winner, position);
        } else {
            if (whiteCurrentRow == 0) {
                winner = "White";
                position = getPosition(whiteCurrentRow, whiteCurrentCol);

            } else {
                winner = "Black";
                position = getPosition(blackCurrentRow, blackCurrentCol);
            }
            System.out.printf("Game over! %s pawn is promoted to a queen at %s.", winner, position);
        }
    }

    private static String getPosition(int r, int c) {
        String position;
        char letter = (char) (97 + c);
        char number = (char) (56 - r);
        String positonLetter = String.valueOf(letter);
        String postionNumber = String.valueOf(number);
        position = positonLetter + postionNumber;
        return position;
    }

    private static boolean doesCapture(int whiteCurrentRow, int whiteCurrentCol, int blackCurrentRow, int blackCurrentCol) {
        if (whiteCurrentCol == blackCurrentCol + 1 || whiteCurrentCol == blackCurrentCol - 1) {
            if (whiteCurrentRow == blackCurrentRow + 1) {
                pawnCapture = true;
                return true;
            }
        }
        return false;
    }
}
