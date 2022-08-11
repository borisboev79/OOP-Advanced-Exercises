package OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise;

import OOP.DesignPatterns_Exercise.company.factoryPattern.factoryExercise.Cakes.Cake;

public class PastryShop {


    public static Cake deliverCake(String cakeType){
        Cake cake = BakingFactory.createCake(cakeType);
        cake.prepare();
        cake.bake();
        cake.box();
        return cake;
    }
}
