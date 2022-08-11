package OOP.Inheritance_Lab.L04_RandomArrayList;


import com.sun.jdi.ArrayReference;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList();
        randomArrayList.add(1);
        randomArrayList.add(2);
        randomArrayList.add(3);
        randomArrayList.add(4);

        System.out.println(randomArrayList.getRandomElement());
    }
}
