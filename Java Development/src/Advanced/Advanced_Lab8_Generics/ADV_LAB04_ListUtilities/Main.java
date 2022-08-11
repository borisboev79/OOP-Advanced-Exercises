package Advanced.Advanced_Lab8_Generics.ADV_LAB04_ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(13, 42, 68, 73);

        System.out.println(ListUtils.getMin(numbers));
        System.out.println(ListUtils.getMax(numbers));

    }
}
