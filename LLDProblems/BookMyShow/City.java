package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Theatre> theatres;

    public String getName() {
        return name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public City(String name) {
        this.name = name;
        this.theatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre){
        theatres.add(theatre);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", theatres=" + theatres +
                '}';
    }
}
