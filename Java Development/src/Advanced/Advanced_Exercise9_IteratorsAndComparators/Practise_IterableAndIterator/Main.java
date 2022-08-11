package Advanced.Advanced_Exercise9_IteratorsAndComparators.Practise_IterableAndIterator;


import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf("orange", "banana", "apple");

        Iterator<String> shopGirl = shelf.iterator();

        while(shopGirl.hasNext()){
            System.out.println(shopGirl.next());
        }

    }
}
