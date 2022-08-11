package Advanced.Advanced_Exercise9_IteratorsAndComparators.Practise_Comparable;

public class Movie implements Comparable<Movie> {
    private String name;
    private int rating;
    private int price;

    public Movie(String name, int rating, int price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }












    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Movie anotherMovie) {
        //тук си избираме по кое поле ще сравняваме, примерно по имена

        return this.getName().compareTo(anotherMovie.getName()); // тук вариантите са отрицателно число, 0 или положително и от това се разбира равни ли са, първото ли е по-голямо или второто
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
