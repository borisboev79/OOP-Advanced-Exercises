package Advanced.Advanced_Exercise9_IteratorsAndComparators.ADV_EXS01_ListyIterator;

import java.util.List;

public class ListyIterator {
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
}
