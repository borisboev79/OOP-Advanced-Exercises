package Advanced.Advanced_Lab2_MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ADV_LAB08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            int[] row = ScannerToIntArray(scanner);
            matrix[i] = row;
        }
        int[] coordinates = ScannerToIntArray(scanner);
        int wrong = matrix[coordinates[0]][coordinates[1]];

        int[][] fixedMatrix = new int[n][matrix[0].length];

        for (int i = 0; i < fixedMatrix.length; i++) {

            for (int j = 0; j < fixedMatrix[i].length; j++) {
                if (matrix[i][j] == wrong) {
                    fixedMatrix[i][j] = fixedNum(wrong, matrix, i, j);
                } else {
                    int replace = matrix[i][j];
                    fixedMatrix[i][j] = replace;
                }
            }
        }
        for (int i = 0; i < fixedMatrix.length; i++) {
            for (int j = 0; j < fixedMatrix[i].length; j++) {
                System.out.print(fixedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int fixedNum(int wrong, int[][] wrongMatrix, int row, int col) {
        int correctNum = 0;

        if (row + 1 < wrongMatrix.length) {
            if (wrongMatrix[row + 1][col] != wrong) {
                correctNum += wrongMatrix[row + 1][col];
            }
        }
        if (row - 1 >= 0) {
            if (wrongMatrix[row - 1][col] != wrong) {
                correctNum += wrongMatrix[row - 1][col];
            }
        }
        if (col + 1 < wrongMatrix[row].length) {
            if (wrongMatrix[row][col + 1] != wrong) {
                correctNum += wrongMatrix[row][col + 1];
            }
        }
        if (col - 1 >= 0) {
            if (wrongMatrix[row][col - 1] != wrong) {
                correctNum += wrongMatrix[row][col - 1];
            }
        }
        return correctNum;
    }

    private static int[] ScannerToIntArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }
}
