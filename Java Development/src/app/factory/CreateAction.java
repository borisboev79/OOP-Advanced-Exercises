package app.factory;

import app.contracts.Action;
import app.models.actions.BossFight;
import app.models.actions.OneVsOne;

import java.lang.reflect.InvocationTargetException;

public class CreateAction {
    public static Action generate(String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Action action;
        switch (type) {
            case "OneVsOne":
                action = OneVsOne.class.getConstructor().newInstance();
                break;
            case "BosFight":
                action = BossFight.class.getConstructor().newInstance();
                break;
            default:
                action = null;
        }
        return action;
    }
}
