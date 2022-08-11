package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.annotations.Inject;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.CommandInterpreter;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.Executable;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.Repository;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE = "OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands.";

    private final Repository repository;

    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String[] data) {
        final String commandName = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1);
        Executable executable = null;

        try {
            final Class<? extends Executable> commandClass = (Class<? extends Executable>)
                    Class.forName(CommandInterpreterImpl.COMMAND_PACKAGE + commandName);

            final Constructor<? extends Executable> constructor = commandClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);

            executable = constructor.newInstance(new Object[]{data});

            final Field[] executableFields = executable.getClass().getDeclaredFields();

            final Field[] thisCommandImpl = this.getClass().getDeclaredFields();

            for (Field executableField : executableFields) {
                if (executableField.isAnnotationPresent(Inject.class)) {
                    for (Field field : thisCommandImpl) {
                        if (executableField.getType().equals(field.getType())) {
                            executableField.setAccessible(true);
                            executableField.set(executable, field.get(this));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return executable;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        return null;
    }
}

