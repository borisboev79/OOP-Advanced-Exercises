package OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.core;

import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.Runnable;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.Unit;
import OOP.ReflectionAndAnnotations_Exercise.E04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException | ExecutionControl.NotImplementedException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException | IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String result;
		switch (commandName) {
			case "add":
				result = this.addUnitCommand(data);
				break;
			case "report":
				result = this.reportCommand(data);
				break;
			case "fight":
				result = this.fightCommand(data);
				break;
			case "retire":
				result = this.removeUnitCommand(data);
				break;

			default:
				throw new RuntimeException("Invalid command!");
		}
		return result;
	}

	private String reportCommand(String[] data) {
		String output = this.repository.getStatistics();
		return output;
	}

	private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String unitType = data[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		String output = unitType + " added!";
		return output;
	}

	private String removeUnitCommand(String[] data) throws ExecutionControl.NotImplementedException {
		final String unitType = data[1];
		this.repository.removeUnit(unitType);
		return unitType + " retired!";
	}

	private String fightCommand(String[] data) {
		return "fight";
	}
}
