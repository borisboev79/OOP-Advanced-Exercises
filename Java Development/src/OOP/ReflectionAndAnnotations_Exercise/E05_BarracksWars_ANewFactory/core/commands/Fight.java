package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands;

public class Fight extends Command {

    public Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
