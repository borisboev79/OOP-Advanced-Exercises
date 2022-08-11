package OOP.Encapsulation_Exercise.E05_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Team> teams = new LinkedHashMap<>();

        while (!"END".equals(input)) {
            try {
                String[] data = input.split(";");
                String command = data[0];
                String teamName = data[1];

                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                        break;
                    case "Add":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Player player = new Player(data[2],
                                    Integer.parseInt(data[3]),
                                    Integer.parseInt(data[4]),
                                    Integer.parseInt(data[5]),
                                    Integer.parseInt(data[6]),
                                    Integer.parseInt(data[7]));

                            teams.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerToRemove = data[2];
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            teams.get(teamName).removePlayer(playerToRemove);
                        }
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
