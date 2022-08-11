package Advanced.Advanced_ExamPreparation1;

import java.util.Scanner;

public class MouseAndCheese {

    private static int mouseRow = 0;
    private static int mouseCol = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            field[row] = line.toCharArray();

            if (line.contains("M")) {
                mouseRow = row;
                mouseCol = line.indexOf("M");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.equals("up")) {
                moveMouse(field, -1, 0);
            } else if (command.equals("down")) {
                moveMouse(field, 1, 0);
            } else if (command.equals("left")) {
                moveMouse(field, 0, -1);
            } else if (command.equals("right")) {
                moveMouse(field, 0, 1);
            }

            if (!mouseIsInField) {
                break;
            }

            command = scanner.nextLine();
        }

        if (!mouseIsInField) {
            System.out.println("Where is the mouse?");

        }

        if (eatenCheese >= 5) {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }

        print2dArray(field);
    }

    private static void moveMouse(char[][] field, int rowMutator, int colMutator) {

        int nextRow = mouseRow + rowMutator;
        int nextCol = mouseCol + colMutator;

        boolean isBonusHit = false;

        if (!isInBounds(field, nextRow, nextCol)) {
            field[mouseRow][mouseCol] = '-';
            mouseIsInField = false;
            return;
        }

        if (field[nextRow][nextCol] == 'c') {
            eatenCheese++;
        } else if (field[nextRow][nextCol] == 'B') {
            isBonusHit = true;
        }

        field[mouseRow][mouseCol] = '-';
        field[nextRow][nextCol] = 'M';
        mouseRow = nextRow;
        mouseCol = nextCol;


        if (isBonusHit) {
            moveMouse(field, rowMutator, colMutator);
        }

    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static void print2dArray(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

}
