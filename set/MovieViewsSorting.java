package set;


import java.util.Comparator;
import java.util.TreeSet;

class Movie {
    private String name;
    private int views;

    public Movie(String name, int views) {
        this.name = name;
        this.views = views;
    }

    public String getName() {
        return name;
    }

    public int getViews() {
        return views;
    }

    @Override
    public String toString() {
        return "Movie: " + name + ", Views: " + views;
    }
}

public class MovieViewsSorting {
    public static void main(String[] args) {
        TreeSet<Movie> movies = new TreeSet<>(Comparator.comparingInt(Movie::getViews).reversed());

       
        movies.add(new Movie("The Avengers", 1000000));
        movies.add(new Movie("Inception", 850000));
        movies.add(new Movie("Interstellar", 900000));
        movies.add(new Movie("The Dark Knight", 1100000));
        movies.add(new Movie("Avatar", 950000));

        System.out.println("Movies sorted by number of views in descending order:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
