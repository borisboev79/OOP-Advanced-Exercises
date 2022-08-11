package Advanced.Advanced_ExamPreparation_Exercises.DefiningClasses.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.remove(this.roster.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null));
    }

    public void promotePlayer(String name) {
        Player promoted = this.roster.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
        if (promoted != null && !promoted.getRank().equals("Member")) {
            promoted.setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        Player demoted = this.roster.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
        if (demoted != null && !demoted.getRank().equals("Trial")) {
            demoted.setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        Player[] toBeRemoved = this.roster.stream().filter(c -> c.getClazz().equals(clazz)).toArray(Player[]::new);
        for (Player player : toBeRemoved) {
            roster.remove(player);
        }
        return toBeRemoved;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        return "Players in the guild: " + this.name + ":" + System.lineSeparator() +
                this.roster.stream().map(Player::toString).collect(Collectors.joining(System.lineSeparator()));
    }

}
