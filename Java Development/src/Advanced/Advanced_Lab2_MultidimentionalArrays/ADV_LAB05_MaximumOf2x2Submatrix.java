package Advanced.Advanced_Lab2_MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ADV_LAB05_MaximumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        int[][] smallMatrix = new int[2][2];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        int maxSum = Integer.MIN_VALUE;
        int resultRow;
        int resultCol;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currSum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1];

                if (maxSum < currSum) {
                    maxSum = currSum;
                    resultRow = row;
                    resultCol = col;
                    for (int smallRow = 0; smallRow < smallMatrix.length; smallRow++) {
                        for (int smallCol = 0; smallCol < smallMatrix[smallRow].length; smallCol++) {

                            smallMatrix[smallRow][smallCol] = matrix[resultRow + smallRow][resultCol + smallCol];
                        }
                    }
                }
            }
        }
        for (int row = 0; row < smallMatrix.length; row++) {
            for (int col = 0; col < smallMatrix[row].length; col++) {
                System.out.print(smallMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
