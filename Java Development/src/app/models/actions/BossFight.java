package app.models.actions;

import app.contracts.Action;
import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.BaseHero;
import app.models.participants.Boss;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {
    @Override
    public String executeAction(List<Targetable> participants) {

        if (participants.isEmpty()) {
            return "There should be at least 1 participant for boss fight!";
        }

        Targetable boss = participants.stream().filter(p -> p.getClass().getSimpleName().equals("Boss"))
                .findFirst().orElse(null);

        List<Targetable> heroes = participants.stream().filter(p -> !p.getClass().getSimpleName().equals("Boss")).toList();

        List<Targetable> aliveHeroes = heroes.stream().filter(Targetable::isAlive).toList();


        assert boss != null;

            while (boss.isAlive()) {

                for (Targetable hero : heroes) {
                hero.attack(boss);

                if (!boss.isAlive()) {
                    boss.giveReward(hero);
                    aliveHeroes.forEach(Targetable::levelUp);

                    for (Targetable aliveHero : aliveHeroes) {

                        assert aliveHero instanceof BaseHero;

                        ((BaseHero) aliveHero).setGold(Config.BOSS_INDIVIDUAL_REWARD);
                    }

                    return boss.getName() + " has been slain by:" + System.lineSeparator() +
                            aliveHeroes.stream()
                                    .sorted(Comparator.comparing(Targetable::getName))
                                    .map(Targetable::toString)
                                    .collect(Collectors.joining(System.lineSeparator()));
                }

                boss.attack(hero);

                if (!hero.isAlive()) {
                    break;

                }
            }
        }
        return "Boss has slain them all!";
        }


    }
