package OOP.Encapsulation_Exercise.E05_FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {

        this.endurance = statException("Endurance", endurance);
    }

    private void setSprint(int sprint) {
        this.sprint = statException("Sprint", sprint);
    }

    private void setDribble(int dribble) {
        this.dribble = statException("Dribble", dribble);
    }

    private void setPassing(int passing) {
        this.passing = statException("Passing", passing);
    }

    private void setShooting(int shooting) {
        this.shooting = statException("Shooting", shooting);
    }

    public double overallSkillLevel(){
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    private int statException(String name, int stat) {
        if (stat < 0  || stat > 100) {
            throw new IllegalArgumentException(name + " should be between 0 and 100.");
        } else {
            return stat;
        }
    }
}
