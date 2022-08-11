package Advanced.Advanced_Exam_June;

import java.util.Scanner;

public class StickyFingers {

    private static int burglarRow = -1;
    private static int burglarCol = -1;

    private static boolean isCauhtByPolice = false;
    private static int moneyStolen = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {

            String line = scanner.nextLine().replace(" ", "");

            matrix[row] = line.toCharArray();

            if (line.contains("D")) {
                burglarRow = row;
                burglarCol = line.indexOf("D");
            }
        }

        for (String command : commands) {
            switch (command) {
                case "up":
                    moveBurgler(matrix, -1, 0);
                    break;
                case "down":
                    moveBurgler(matrix, 1, 0);
                    break;
                case "left":
                    moveBurgler(matrix, 0, -1);
                    break;
                case "right":
                    moveBurgler(matrix, 0, 1);
                    break;
            }
        }

        if (isCauhtByPolice) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", moneyStolen);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", moneyStolen);
        }
        print2dArray(matrix);
    }

    private static void moveBurgler(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = burglarRow + rowMutator;
        int nextCol = burglarCol + colMutator;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[burglarRow][burglarCol] = '+';
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }

        char destination = matrix[nextRow][nextCol];

        if (destination == 'P') {
            matrix[nextRow][nextCol] = '#';
            isCauhtByPolice = true;
        } else if (destination == '$') {
            int loot = nextRow * nextCol;
            moneyStolen += loot;
            System.out.printf("You successfully stole %d$.%n", loot);

        }
        matrix[burglarRow][burglarCol] = '+';
        if (isCauhtByPolice) {
            return;
        } else {
            burglarRow = nextRow;
            burglarCol = nextCol;
            matrix[burglarRow][burglarCol] = 'D';
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
