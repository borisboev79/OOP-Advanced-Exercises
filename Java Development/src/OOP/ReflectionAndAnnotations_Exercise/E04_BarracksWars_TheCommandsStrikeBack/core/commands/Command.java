package OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.core.commands;

import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.Executable;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private final String data;
    private final Repository repository;
    private final UnitFactory unitFactory;

    public Command(String data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String getData() {
        return this.data;
    }

    public Repository getRepository() {
        return this.repository;
    }

    public UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}
