package Advanced.Advanced_Exercise9_IteratorsAndComparators.Practise_Comparator;

import java.util.Comparator;

public class MoviePriceComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie first, Movie second) {
        return Integer.compare(first.getRating(), second.getRating());
    }
}
