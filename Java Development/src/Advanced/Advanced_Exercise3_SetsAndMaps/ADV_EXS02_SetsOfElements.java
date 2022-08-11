package Advanced.Advanced_Exercise3_SetsAndMaps;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
public class ADV_EXS02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Set<Integer> nSet = new LinkedHashSet<>();
        Set<Integer> mSet = new LinkedHashSet<>();
        int input = 0;
        for (int i = 0; i < n  ; i++) {
            input = Integer.parseInt(scanner.nextLine());
            nSet.add(input);
        }
        for (int i = 0; i < m; i++) {
            input = Integer.parseInt(scanner.nextLine());
            mSet.add(input);
        }
        Set<Integer> matchingNums = new LinkedHashSet<>();
        for (int num: nSet
        ) {
            if(mSet.contains(num)){
                matchingNums.add(num);
            }
        }
        matchingNums.forEach(e -> System.out.print(e + " "));;
    }
}
