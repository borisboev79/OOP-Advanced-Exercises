package Advanced.Advanced_Exercise3_SetsAndMaps;
import java.util.*;
public class ADV_EXS03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            set.addAll(Arrays.asList(elements));
        }
        set.forEach(e -> System.out.print(e + " "));
    }
}
