package Advanced.Advanced_Exercise2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ADV_EXS05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] dimensions = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        for (int row = 0; row < matrix.length; row++) {
            line = scanner.nextLine();
            matrix[row] = line.split("\\s+");

        }

        while (!"END".equals(line = scanner.nextLine())) {

            String[] swapCommand = line.split("\\s+");

            if (!swapCommand[0].equals("swap") || swapCommand.length != 5) {
                System.out.println("Invalid input!");
                continue;

            }

            int fromRow = Integer.parseInt(swapCommand[1]);
            int fromCol = Integer.parseInt(swapCommand[2]);
            int toRow = Integer.parseInt(swapCommand[3]);
            int toCol = Integer.parseInt(swapCommand[4]);

            if (!isValid(matrix, fromRow, fromCol, toRow, toCol)) {
                System.out.println("Invalid input!");
                continue;
            }
            String temp = matrix[fromRow][fromCol];
            matrix[fromRow][fromCol] = matrix[toRow][toCol];
            matrix[toRow][toCol] = temp;

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }

        }
    }

    private static boolean isValid(String[][] matrix, int oldRow, int oldCol, int newRow, int newCol) {

        int[] rowIndexes = {oldRow, newRow};
        int[] colIndexes = {oldCol, newCol};

        for (int rowIndex : rowIndexes) {
            if (rowIndex < 0 || rowIndex > matrix.length) {
                return false;
            }
        }
        for (int colIndex : colIndexes) {
            if (colIndex < 0 || colIndex > matrix[0].length) {
                return false;
            }
        }
        return true;
    }
}
