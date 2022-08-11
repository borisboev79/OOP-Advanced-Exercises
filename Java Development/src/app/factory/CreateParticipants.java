package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

import java.lang.reflect.InvocationTargetException;

public class CreateParticipants implements TargetableFactory {

    public Targetable create(String name, String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Targetable participant = null;
        switch (type) {
            case "Boss":
                participant = Boss.class.getConstructor(String.class).newInstance(name);
                break;
            case "Wizard":
                participant = Wizard.class.getConstructor(String.class).newInstance(name);
                break;
            case "Warrior":
                participant = Warrior.class.getConstructor(String.class).newInstance(name);
                break;
            case "Necromancer":
                participant = Necromancer.class.getConstructor(String.class).newInstance(name);
                break;
        }

        return participant;
    }
}
