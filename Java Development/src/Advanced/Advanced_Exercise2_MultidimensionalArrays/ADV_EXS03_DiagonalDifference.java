package Advanced.Advanced_Exercise2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ADV_EXS03_DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] rowInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowInput;
        }
        int mainDiagonalSum = 0;
        for (int counter = 0; counter < n; counter++) {
            mainDiagonalSum += matrix[counter][counter];
        }
        int secondaryDiagonalSum = 0;
        for (int row = 0, col = n -1; row < n;  row++, col--) {
            secondaryDiagonalSum += matrix[row][col];
        }
        System.out.printf("%d", Math.abs(mainDiagonalSum - secondaryDiagonalSum));


    }
}
