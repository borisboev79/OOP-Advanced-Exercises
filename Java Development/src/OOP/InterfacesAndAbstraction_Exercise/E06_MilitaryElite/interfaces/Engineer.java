package OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.interfaces;

import OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.Repair;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {
    public void addRepair(Repair repair);

    public Collection<Repair> getRepairs();


}
