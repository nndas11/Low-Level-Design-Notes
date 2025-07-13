package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

public class Movie {
    private final int id;
    private final String name;
    private final int durationInMinutes;
    private final String genre;
//    we can add extra as we need info.

    public Movie(int id, String name, int durationInMinutes, String genre) {
        this.id = id;
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", genre='" + genre + '\'' +
                '}';
    }
}
