package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.annotations.Inject;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.Repository;

public class Report extends Command {

    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}

