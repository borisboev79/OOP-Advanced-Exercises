package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class BaseHero implements Hero {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private String name;
    private boolean isAlive;
    private double gold;

    public BaseHero(String name) {
        this.isAlive = true;
        this.level = 1;
        setGold(gold);
        setName(name);
        setStrength(strength);
        setDexterity(dexterity);
        setHealth(health);
        setIntelligence(intelligence);
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
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        health = strength * Config.HERO_HEALTH_MULTIPLIER;
        this.health = health;
    }

    @Override
    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        gold = Config.HERO_START_GOLD;
        this.gold = gold;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
       this.intelligence = intelligence;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
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
        if (getHealth() <= 0) {
            isAlive = false;
        }
    }

    @Override
    public void giveReward(Targetable targetable) {
        if (targetable instanceof Hero) {
            targetable.receiveReward(getGold());
            setGold(0);
        } else if (targetable instanceof Boss) {
            targetable.receiveReward(getGold() * 0.10);
            this.setGold(getGold() * 0.9);
        }

    }

    @Override
    public void receiveReward(double reward) {
        setGold(getGold() + reward);
    }

    @Override
    public void levelUp() {
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.level += 1;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()) + System.lineSeparator() +
                String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()) + System.lineSeparator() +
                String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold);
    }
}
