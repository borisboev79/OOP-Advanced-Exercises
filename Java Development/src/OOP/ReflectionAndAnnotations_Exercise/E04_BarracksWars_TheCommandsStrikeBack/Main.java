package OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack;

import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.core.Engine;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.data.UnitRepository;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.Runnable;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
