package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.factories;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands.Command;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.CommandFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactoryImpl implements CommandFactory {

    private static final String COMMANDS_PACKAGE_NAME = "OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands.";

    @SuppressWarnings("all")
    public Command createCommand(String commandName, String[] data) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        Class<Command> commandClass = (Class<Command>) Class.forName(COMMANDS_PACKAGE_NAME + commandName);

        Constructor<Command> commandConstructor = commandClass.getDeclaredConstructor(String[].class);
        commandConstructor.setAccessible(true);

        return commandConstructor.newInstance(new Object[]{data});
    }
}

