package OOP.InterfacesAndAbstraction_Exercise.E07_CollectionHieararchy;

public class AddCollection extends Collection implements Addable{


    @Override
    public int add(String element) {
       items.add(element);
        return items.indexOf(element);
    }
}
