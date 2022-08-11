package OOP.ReflectionAndAnnotations_Exercise.E03_BarracksWars;


import OOP.ReflectionAndAnnotations_Exercise.E03_BarracksWars.core.Engine;
import OOP.ReflectionAndAnnotations_Exercise.E03_BarracksWars.core.factories.UnitFactoryImpl;
import OOP.ReflectionAndAnnotations_Exercise.E03_BarracksWars.data.UnitRepository;
import OOP.ReflectionAndAnnotations_Exercise.E03_BarracksWars.interfaces.Repository;
import OOP.ReflectionAndAnnotations_Exercise.E03_BarracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
