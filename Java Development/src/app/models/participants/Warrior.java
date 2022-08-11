package app.models.participants;

import app.models.Config;

public class Warrior extends BaseHero{

    public Warrior(String name) {
        super(name);
        setStrength(super.getStrength());
        setDexterity(super.getDexterity());
        setIntelligence(super.getIntelligence());
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(Config.WARRIOR_BASE_STRENGTH);
    }

    @Override
    public void setDexterity(int dexterity) {
        super.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
    }

    @Override
    public void setIntelligence(int intelligence) {
        super.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return getStrength() * 2 + getDexterity();
    }

}
