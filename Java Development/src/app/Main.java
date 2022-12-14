package app;

import app.contracts.Battlefield;
import app.core.BattlefieldImplementation;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        Battlefield battleField = new BattlefieldImplementation(writer);

        String line = reader.readLine();
        while (!line.equals("Peace")){
            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0].toLowerCase()){
                case "createparticipant" :
                    battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case "createaction" :
                    String action = lineTokens[1];
                    String[] participants = Arrays.stream(lineTokens).skip(2).toArray(String[]::new);
                    String allParticipants = String.join(" ", participants);
                    battleField.createAction(action, participants);
                    break;
                case "statactions":
                    battleField.reportActions();
                    break;
                case "statparticipants":
                    battleField.reportParticipants();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            line = reader.readLine();
        }

    }
}
