package Advanced.Advanced_Exercise9_IteratorsAndComparators.ADV_EXS02_Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        currentIndex = 0;

    }

    public boolean hasNext(){
        return currentIndex < elements.size() - 1;
    }

    public boolean move(){
        if(hasNext()){
            this.currentIndex++;
            return true;
        }
        return false;
    }

   public void print(){
        if(this.elements.isEmpty()){
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(currentIndex));
        }
   }

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {
            private int index;
            @Override
            public boolean hasNext() {
                return this.index < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(index++);
                return element;
            }
        };
    }
}
