package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss implements Targetable {
    private String name;
    private double health;
    private double gold;
    private boolean isAlive;

    public Boss(String name) {
        setName(name);
        setHealth(health);
        this.gold = Config.BOSS_GOLD;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";

        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public void takeDamage(double damage) {
        setHealth(Math.max(0, getHealth() - damage));
        isAlive = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getGold() {
        return gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = Config.BOSS_HEALTH;
    }

    @Override
    public void giveReward(Targetable targetable) {
       // this.setHealth(0);
      //  isAlive = false;
        targetable.receiveReward(this.gold);
        this.gold = 0;

    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public void levelUp() {
            this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}
