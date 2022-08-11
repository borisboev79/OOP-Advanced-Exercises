package OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.core.factories;

import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.Unit;
import OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "OOP.ReflectionAndAnnotations_Exercise.E05_BarracksWars_ANewFactory.models.units.";

	@Override
	@SuppressWarnings("unchecked")
	public Unit createUnit(String unitType) throws InvocationTargetException,
			NoSuchMethodException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException {

		Class<Unit> unitClass = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);

		return createUnit(unitClass);
	}

	private Unit createUnit(Class<Unit> unitClass) throws NoSuchMethodException,
			IllegalAccessException,
			InvocationTargetException,
			InstantiationException {

		Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
		constructor.setAccessible(true);

		return constructor.newInstance();
	}
}

