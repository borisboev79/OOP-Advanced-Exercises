package Advanced.Advanced_Lab2_MultidimentionalArrays;
import java.util.Arrays;
import java.util.Scanner;
public class ADV_LAB06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n ; row++) {
            int[] inputRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < n; col++) {
                matrix[row] = inputRow;
            }
        }
        for (int i = 0; i < n; i++) {
            int diagonalNum = matrix[i][i];
            System.out.print(diagonalNum + " ");
        }
        System.out.println();

        for (int i = n - 1; i >= 0 ; i--) {
            int diagonalNum = matrix[i][n - 1 - i];
            System.out.print(diagonalNum + " ");
        }
        System.out.println();
    }
}
