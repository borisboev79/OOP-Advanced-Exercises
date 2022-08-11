package OOP.InterfacesAndAbstraction_Exercise.E07_CollectionHieararchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected int maxSize;
    protected List<String> items;

    public Collection() {
        maxSize = 100;
        items = new ArrayList<>();
    }
}