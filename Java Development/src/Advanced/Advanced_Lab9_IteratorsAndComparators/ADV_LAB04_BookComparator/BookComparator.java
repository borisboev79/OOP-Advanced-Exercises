package Advanced.Advanced_Lab9_IteratorsAndComparators.ADV_LAB04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book f, Book s) {
        return f.compareTo(s);
    }

}
