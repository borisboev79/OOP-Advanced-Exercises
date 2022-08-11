package Advanced.Advanced_Exercise9_IteratorsAndComparators.Practise_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Movie movie1 = new Movie("Harry Potter", 8, 15);
        Movie movie2 = new Movie("Lord of the Rings", 9, 16);
        Movie movie3 = new Movie("Astronaut", 7, 5);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        Collections.sort(movies);
        // Comparable -> нещо, което може да се сравнява - за да може да се сравняват, първо трябва да си научим класа да бъде сравним

        for ( Movie m : movies) {

            System.out.println(m);
        }

    }
}
