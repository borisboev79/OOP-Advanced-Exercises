package app.core;

import app.contracts.Action;
import app.contracts.Battlefield;
import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.factory.CreateAction;
import app.factory.CreateParticipants;
import app.io.ConsoleWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    ConsoleWriter writer;
    TargetableFactory targetableFactory;

    public BattlefieldImplementation(ConsoleWriter writer) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.targetableFactory = new CreateParticipants();
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            Action action = CreateAction.generate(actionName);

            List<Targetable> actionParticipants = new ArrayList<>();

            for (String name : participantNames) {
                if (this.participants.containsKey(name)) {
                    actionParticipants.add(this.participants.get(name));

                } else {
                    System.out.printf("%s is not on the battlefield. %s failed.%n", name, actionName);
                    return;
                }

            }

            System.out.println(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            System.out.println("Action does not exist.");
        }
    }

    @Override
    public void createParticipant(String name, String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        if (this.participants.containsKey(name)) {
            System.out.println("Participant with that name already exists.");
            return;
        }

        Targetable targetable = targetableFactory.create(name, className);

        if (targetable == null) {
            System.out.println("Participant class does not exist.");
        } else {
            participants.put(name, targetable);
            System.out.printf("%s %s entered the battlefield.%n",
                    targetable.getClass().getSimpleName(),
                    targetable.getName());
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants() {
        if (this.participants.size() < 1) {
            System.out.println("There are no participants on the battlefield.");
            return;
        }

        for (String name : this.participants.keySet()) {
            System.out.println(this.participants.get(name).toString());
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions() {
        if (this.executedActions.size() < 1) {
            System.out.println("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : executedActions) {
            System.out.println(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants() {
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()) {
                System.out.printf("%s has been removed from the battlefield.%n", name);
            } else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
