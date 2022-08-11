package Advanced.Advanced_Lab3_SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ADV_LAB02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> reservation = new TreeSet<>();
        //    Set<String> regular = new LinkedHashSet<>();

        String reservationNumber = scanner.nextLine();

        while (!reservationNumber.equals("PARTY")) {


            reservation.add(reservationNumber);


            reservationNumber = scanner.nextLine();
        }
        String guestReservation = scanner.nextLine();
        while (!guestReservation.equals("END")) {
            reservation.remove(guestReservation);


            guestReservation = scanner.nextLine();
        }
        System.out.println(reservation.size());
        System.out.println(String.join(System.lineSeparator(), reservation));
    }

}
