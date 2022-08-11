package Advanced.Advanced_Lab2_MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ADV_LAB04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] rowInput = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row] = rowInput;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);
    }
}
