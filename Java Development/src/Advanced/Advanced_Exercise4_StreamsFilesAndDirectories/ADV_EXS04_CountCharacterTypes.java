package Advanced.Advanced_Exercise4_StreamsFilesAndDirectories;

import java.io.*;

public class ADV_EXS04_CountCharacterTypes {
    public static void main(String[] args) {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (FileReader fr = new FileReader("C:\\Users\\Boevi StudentSytem.OOP.WorkingWithAbstraction_Exercise.Е05_JedyGalaxy.L04_FirstAndReserveTeam.Task4.OOP.ReflectionAndAnnotations_Lab.L02_GettersAndSetters.OOP.DesignPatterns_Lab.Command.Main\\OneDrive\\Документи\\Java\\Advanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
             PrintWriter pw = new PrintWriter("D:\\Java Exercises\\Output\\output.txt")) {
            int oneSymbol = fr.read();

            while (oneSymbol >= 0) {
                char symbolAsChar = (char) oneSymbol;
                if (isVowel(symbolAsChar)) {
                    vowels++;
                } else if (isPunctuation(symbolAsChar)) {
                    punctuation++;
                } else if (!Character.isWhitespace(symbolAsChar)) {
                    consonants++;
                }
                oneSymbol = fr.read();
            }
            pw.println("Vowels: " + vowels);
            pw.println("Consonants: " + consonants);
            pw.println("Punctuation: " + punctuation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static boolean isVowel ( char character){
            return character == 'a' || character == 'o' || character == 'u' || character == 'e' || character == 'i';
        }

        private static boolean isPunctuation ( char character){
            return character == '!' || character == ',' || character == '.' || character == '?';

        }
    }
