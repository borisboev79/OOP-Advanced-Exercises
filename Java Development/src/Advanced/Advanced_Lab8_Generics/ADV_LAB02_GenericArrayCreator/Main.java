package Advanced.Advanced_Lab8_Generics.ADV_LAB02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.create(13, 69);
        for (Integer integer : arr
             ) {
            System.out.println(integer);
        }
    }
}
