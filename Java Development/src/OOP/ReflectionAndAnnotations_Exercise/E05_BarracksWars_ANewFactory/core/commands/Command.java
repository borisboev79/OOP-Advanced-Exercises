package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.Executable;

public abstract class Command implements Executable {

    private final String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }

}


