package OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.soldiers;

import OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.Mission;
import OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.enums.Corps;
import OOP.InterfacesAndAbstraction_Exercise.E06_MilitaryElite.interfaces.Commando;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);

    }

    @Override
    public Collection<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(getCorps())
                .append(System.lineSeparator())
                .append("Missions:");

        if (!missions.isEmpty()) {
            sb.append(System.lineSeparator())
                    .append(missions.stream().map(Mission::toString).collect(Collectors.joining(System.lineSeparator())));
        }
        return sb.toString();
    }

}

