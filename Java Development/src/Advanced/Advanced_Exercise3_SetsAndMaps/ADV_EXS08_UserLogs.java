package Advanced.Advanced_Exercise3_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ADV_EXS08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputParts = input.split(" ");
            String ipParts = inputParts[0];
            String userNameParts = inputParts[2];
            String ipAddress = ipParts.substring(3);
            String userName = userNameParts.substring(5);

            if (!usersMap.containsKey(userName)) {
                usersMap.put(userName, new LinkedHashMap<>());
            }
            if (!usersMap.get(userName).containsKey(ipAddress)) {
                usersMap.get(userName).put(ipAddress, 1);
            } else {
                int ipAttacksCounter = usersMap.get(userName).get(ipAddress) + 1;
                usersMap.get(userName).put(ipAddress, ipAttacksCounter);
            }


            input = scanner.nextLine();
        }
        for (var attacker : usersMap.entrySet()) {
            System.out.printf("%s:%n", attacker.getKey());
            LinkedHashMap<String, Integer> attacks = attacker.getValue();
            StringBuilder sb = new StringBuilder();

            for (var singleIpAttack : attacks.entrySet()) {
                String formattedAttack = String.format("%s => %d, ", singleIpAttack.getKey(), singleIpAttack.getValue());
                sb.append(formattedAttack);
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";

            System.out.println(finalOutput);
        }

    }
}


