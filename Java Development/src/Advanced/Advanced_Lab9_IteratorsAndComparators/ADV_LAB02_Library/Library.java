package Advanced.Advanced_Lab9_IteratorsAndComparators.ADV_LAB02_Library;

import java.util.Arrays;
import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return Arrays.stream(books).iterator();

    }



}
