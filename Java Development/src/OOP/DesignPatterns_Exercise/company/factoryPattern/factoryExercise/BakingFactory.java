package OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise;

import OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise.Cakes.BiscuitCake;
import OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise.Cakes.Cake;
import OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise.Cakes.ChocolateCake;
import OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise.Cakes.SpinachCake;

public class BakingFactory {

    public static Cake createCake(String type) {
        Cake cake = null;
        switch (type){
            case"ChocolateCake":
                cake = new ChocolateCake(12, 12, 12);
                break;
                case"BiscuitCake":
                cake = new BiscuitCake(14, 14, 14);
                break;
            case"SpinachCake":
                cake = new SpinachCake(16, 16, 16);
                break;
        }
        return cake;
    }
}
