package app.models.participants;

import app.models.Config;

public class Wizard extends BaseHero {

    public Wizard(String name) {
        super(name);
        setStrength(super.getStrength());
        setDexterity(super.getDexterity());
        setIntelligence(super.getIntelligence());
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
    }

    @Override
    public void setDexterity(int dexterity) {
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
    }

    @Override
    public void setIntelligence(int intelligence) {
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return getIntelligence() * 5 + getDexterity();
    }
}
