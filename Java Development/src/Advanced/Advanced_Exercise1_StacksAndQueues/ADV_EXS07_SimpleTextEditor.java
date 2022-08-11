package Advanced.Advanced_Exercise1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ADV_EXS07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String rawCommands = scanner.nextLine();
            String[] commandArguments = rawCommands.split(" ");
            String commandType = commandArguments[0];
            switch (commandType) {
                case "1":
                    commands.push(rawCommands);
                    executeAdd(commandArguments[1], text);
                    //          System.out.println(text);
                    break;
                case "2":
                    commands.push(rawCommands);
                    int countToDelete = Integer.parseInt(commandArguments[1]);
                    StringBuilder sb = new StringBuilder();
                    for (int j = text.length() - countToDelete; j < text.length(); j++) {
                        sb.append(text.charAt(j));
                    }
                    removedElements.push(sb.toString());
                    executeDelete(countToDelete, text);
                    //      System.out.println(text);
                    break;
                case "3":
                    int index = Integer.parseInt(commandArguments[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    String lastCommand = commands.pop();
                    String[] lastCommandArguments = lastCommand.split(" ");
                    String lastCommandType = lastCommandArguments[0];
                    switch (lastCommandType) {
                        case "1":
                            int elementToDelete = lastCommandArguments[1].length();
                            executeDelete(elementToDelete, text);
                            //        System.out.println(text);
                            break;
                        case "2":
                            String elementsToAddBack = removedElements.pop();
                            executeAdd(elementsToAddBack, text);
                            //System.out.println(text);
                            break;

                    }
                    break;
            }
        }
        // System.out.println(text);
    }

    private static void executeDelete(int countToDelete, StringBuilder text) {
        for (int i = 1; i <= countToDelete; i++) {
            text.deleteCharAt(text.length() - 1);
        }
    }

    private static void executeAdd(String commandArgument, StringBuilder text) {
        text.append(commandArgument);
    }
}
