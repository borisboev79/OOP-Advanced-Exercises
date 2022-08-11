package Advanced.Advanced_Lab3_SetsAndMaps;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class ADV_LAB04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> map = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(key -> {

                 /*   Integer oldValue = map.get(key);
                    int newValue = 1;
                    if(oldValue != null){
                        newValue += oldValue;
                    }
                     map.put(key, newValue);*/

                    if(map.containsKey(key)){
                        int oldCount = map.get(key);
                        int newCount = oldCount + 1;
                        map.put(key, newCount);
                    } else{
                        map.put(key, 1);
                    }


                });

        for (var entry : map.entrySet()
             ) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
