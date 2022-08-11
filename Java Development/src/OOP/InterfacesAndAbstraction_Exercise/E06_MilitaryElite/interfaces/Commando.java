package OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.interfaces;

import OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.Mission;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier {
    public void addMission(Mission mission);
    public Collection<Mission> getMissions();
}
