package OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.soldiers;

import OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.enums.Corps;
import OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
       this.corps = corps;
           }


    @Override
    public Corps getCorps() {
        return corps;
    }




}
