package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.CommandInterpreterImpl;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.Engine;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.factories.UnitFactoryImpl;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.data.UnitRepository;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.Repository;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {

        final Repository repository = new UnitRepository();

        final UnitFactory unitFactory = new UnitFactoryImpl();

        final CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        final Engine engine = new Engine(commandInterpreter);

        engine.run();
    }
}

