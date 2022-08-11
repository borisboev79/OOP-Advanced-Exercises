package Advanced.Advanced_Lab9_IteratorsAndComparators.ADV_LAB02_Library_ClassicSolution;

import java.util.Iterator;


public class Library implements Iterable<Book>  {
    private Book[] books;

    public Library(Book... books){
        this.books = books;
    }
    // НЕЩО МНОГО ХИТРО!
//    @Override
//    public Iterator<Book> iterator(){
//        return Arrays.stream(books).iterator();
//    }
    private class LibIterator implements Iterator<Book>{

        private int counter = 0;

        @Override
        public boolean hasNext() {

            return this.counter < books.length;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }





}
