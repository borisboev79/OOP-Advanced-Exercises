package Advanced.Advanced_Lab8_Generics.ADV_LAB03_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("R", "C");

        System.out.println(scale.getHeavier());
    }
}
