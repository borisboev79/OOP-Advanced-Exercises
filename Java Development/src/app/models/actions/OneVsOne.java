package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public class OneVsOne implements Action {

    public String executeAction(List<Targetable> participants) {

        if (participants.size() != 2) {
            return "There should be exactly 2 participants for OneVsOne!";
        }

        StringBuilder sb = new StringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        Targetable winner = null;
        Targetable loser = null;

        while (firstHero.isAlive() && secondHero.isAlive()) {

            System.out.println(firstHero.attack(secondHero));
            if (!secondHero.isAlive()) {
                winner = firstHero;
                loser = secondHero;

                break;
            }
            System.out.println(secondHero.attack(firstHero));
            if (!firstHero.isAlive()) {
                winner = secondHero;
                loser = firstHero;
                break;
            }
            if(!firstHero.isAlive() || !secondHero.isAlive()){
                break;
            }


        }

      //  assert winner != null;
       // loser.giveReward(winner);
       // winner.levelUp();

        return winner.getName() + " is victorious!" + System.lineSeparator() +
                winner;

    }
}
