package OOP.Inheritance_Lab.L04_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList {
    private Random random;

    public Object getRandomElement() {
        random = new Random();
        int randomIndex = this.random.nextInt(super.size());
        return super.remove(randomIndex);

    }
}
