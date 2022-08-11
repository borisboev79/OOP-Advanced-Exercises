package OOP.WorkingWithAbstraction_Exercise.E06_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Treasure {
    private final Map<String, LinkedHashMap<String, Long>> gold;
    private final Map<String, LinkedHashMap<String, Long>> gems;
    private final Map<String, LinkedHashMap<String, Long>> cash;

    Treasure() {
        this.gold = new LinkedHashMap<>();
        this.gems = new LinkedHashMap<>();
        this.cash = new LinkedHashMap<>();
    }

    public void addToGold(String name, Long amount) {
        checkAndAddTreasureType(name, amount, gold, "Gold");
    }

    public void addToGems(String name, Long amount) {
        checkAndAddTreasureType(name, amount, gems, "Gem");
    }

    public void addToCash(String name, Long amount) {
        checkAndAddTreasureType(name, amount, cash, "Cash");
    }

    public long getTotalGold() {
        return getSumOfTreasure(gold);
    }

    public long getTotalGems() {
        return getSumOfTreasure(gems);
    }

    public long getTotalCash() {
        return getSumOfTreasure(cash);
    }

    public long getTotalTreasure() {
        return getTotalGold() + getTotalGems() + getTotalCash();
    }

    public void printTreasures() {
        Map[] treasures = {gold, gems, cash};

        for (Map<String, LinkedHashMap<String, Long>> asset : treasures) {
            for (Map.Entry<String, LinkedHashMap<String, Long>> treasure : asset.entrySet()) {
                long sumValues = treasure.getValue().values().stream().mapToLong(l -> l).sum();

                System.out.printf("<%s> $%s%n", treasure.getKey(), sumValues);

                treasure.getValue().entrySet().stream()
                        .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                        .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
            }
        }
    }

    private long getSumOfTreasure(Map<String, LinkedHashMap<String, Long>> gold) {
        return gold.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
    }

    private void checkAndAddTreasureType(String name, Long amount, Map<String, LinkedHashMap<String, Long>> treasureType, String treasureName) {
        if (!treasureType.containsKey(treasureName)) {
            treasureType.put(treasureName, new LinkedHashMap<>());
        }
        treasureType.get(treasureName).putIfAbsent(name, 0L);
        treasureType.get(treasureName).put(name, treasureType.get(treasureName).get(name) + amount);
    }
}