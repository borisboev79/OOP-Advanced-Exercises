package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}

