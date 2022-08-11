package Advanced.Advanced_Exercise2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ADV_EXS07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = ScannerToIntArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        String line;

        while (!"Nuke it from orbit".equals(line = scanner.nextLine())) {
            int[] blowInstructions = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int blowRow = blowInstructions[0];
            int blowCol = blowInstructions[1];
            int blowRadius = blowInstructions[2];

            if (isValid(blowRow, blowCol, rows, cols)) {
                if (blowRadius == 0) {
                    matrix[blowRow][blowCol] = 0;
                    break;
                }
                if (blowRow < matrix.length && blowCol < matrix[blowRow].length) {
                    matrix[blowRow][blowCol] = 0;
                }

                for (int i = 1; i <= blowRadius; i++) {
                    if (blowRow + i < matrix.length && blowRow + i < matrix[blowRow + i].length) {
                        matrix[blowRow + i][blowCol] = 0;
                    }
                    if (blowRow - i >= 0 && blowRow - i < matrix[blowRow - i].length) {
                        matrix[blowRow - i][blowCol] = 0;
                    }
                    if (blowCol + i < matrix[blowRow].length) {
                        matrix[blowRow][blowCol + i] = 0;
                    }
                    if (blowCol - i >= 0) {
                        matrix[blowRow][blowCol - i] = 0;
                    }
                }
            }
            matrix = TruncateMatrix(matrix, rows);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {

//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                    System.out.print(matrix[row][col] + " ");
//                }
//                if (matrix[row].length > 0) {
//                    System.out.println();
//            }
//        }
        for (int[] matrixRow : matrix) {
            for (int col = 0; col < matrixRow.length; col++) {
                if (matrixRow[col] != 0) {
                    System.out.print(matrixRow[col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] TruncateMatrix(int[][] matrix, int rows) {

        int cycleCount = 0;
        int newRowLength = 0;
        int[][] newMatrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int zeroCounter = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroCounter++;
                }
            }
            newRowLength = matrix[i].length - zeroCounter;

            for (int j = cycleCount; j < rows; j++) {

                int temp = 0;
                int counterX = 0;
                int[] newRowNums = new int[newRowLength];

                for (int k = 0; k < matrix[j].length; k++) {
                    if (matrix[j][k] != 0) {
                        temp = matrix[j][k];
                        newRowNums[counterX++] = temp;
                    }
                }
                newMatrix[j] = newRowNums;
                cycleCount++;

                break;
            }


        }
        return newMatrix;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        if ((row >= 0 && row < rows) && (col >= 0 && col < cols)) {
            return true;
        } else {
            return false;
        }
    }

    private static int[] ScannerToIntArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }

}
