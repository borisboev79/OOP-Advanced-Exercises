package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.annotations.Inject;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            this.repository.removeUnit(this.getData()[1]);
        } catch (Exception e) {
            return e.getMessage();
        }
        return this.getData()[1] + " retired!";
    }
}

