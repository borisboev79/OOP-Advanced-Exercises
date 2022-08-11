package app.models.participants;

import app.models.Config;

public class Necromancer extends BaseHero{

    public Necromancer(String name) {
        super(name);
        setStrength(super.getStrength());
        setDexterity(super.getDexterity());
        setIntelligence(super.getIntelligence());
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(Config.NECROMANCER_BASE_STRENGTH);
    }

    @Override
    public void setDexterity(int dexterity) {
        super.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
    }

    @Override
    public void setIntelligence(int intelligence) {
        super.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return getIntelligence() * 2 + getDexterity() * 2 + getStrength() * 2;
    }

}
