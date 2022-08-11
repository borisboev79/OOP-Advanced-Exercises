package Advanced.Advanced_Exercise9_IteratorsAndComparators.Practise_Comparator;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {


    @Override
    public int compare(Movie first, Movie second) {
        return first.getRating() - second.getRating();

    }
}
