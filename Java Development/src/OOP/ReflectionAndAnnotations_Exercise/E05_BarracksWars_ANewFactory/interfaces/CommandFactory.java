package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.commands.Command;

import java.lang.reflect.InvocationTargetException;

public interface CommandFactory {
    Command createCommand(String commandName, String[] data) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException;
}
