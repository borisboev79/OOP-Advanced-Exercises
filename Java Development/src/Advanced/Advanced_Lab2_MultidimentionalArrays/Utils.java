package Advanced.Advanced_Lab2_MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Utils {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 2;
        int cols = 3;
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] rowInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            //   for (int col = 0; col < cols; col++) {
            // matrix[row][col] = rowInput[col];
            matrix[row] = rowInput;
            //      }
        }
        //print matrix
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        //print multidimensional arrays
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

            System.out.println(matrix.length);
            System.out.println(matrix[0].length);

        }

    }
    //Scanner to Int Array Method
    private static int[] ScannerToIntArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }
}
