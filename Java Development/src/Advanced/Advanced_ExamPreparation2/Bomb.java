package Advanced.Advanced_ExamPreparation2;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        int sapperRow = 0;
        int sapperCol = 0;
        int bombCounter = 0;

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replace(" ", "");
            char[] matrixRow = line.toCharArray();
            for (int j = 0; j < matrixRow.length; j++) {
                char currentChar = matrixRow[j];
                if (currentChar == 's') {
                    sapperRow = i;
                    sapperCol = j;
                } else if (currentChar == 'B') {
                    bombCounter++;
                }

            }
            matrix[i] = matrixRow;

        }
        int bombsFound = 0;

        for (int i = 0; i < commands.length; i++) {
            String commandName = commands[i];
            switch (commandName) {
                case "up":
                    if (sapperRow != 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow != size - 1) {
                        sapperRow++;
                    }
                    break;
                case "right":
                    if (sapperCol != size - 1) {
                        sapperCol++;
                    }
                    break;
                case "left":
                    if (sapperCol != 0) {
                        sapperCol--;
                    }
                    break;
            }
            if (matrix[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                bombsFound++;
                matrix[sapperRow][sapperCol] = '+';
                if (bombsFound == bombCounter) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombCounter - bombsFound);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter - bombsFound, sapperRow, sapperCol);
    }
}

