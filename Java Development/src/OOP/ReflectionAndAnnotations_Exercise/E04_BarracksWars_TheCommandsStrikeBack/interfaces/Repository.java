package OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
