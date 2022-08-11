package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces;

public interface CommandInterpreter {

	@SuppressWarnings("unchecked")
	Executable interpretCommand(String[] data);

	Executable interpretCommand(String[] data, String commandName);
}

