package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listOfScreens=" + listOfScreens +
                '}';
    }

    private int id;
    private String name;
    private List<Screen> listOfScreens;
//    Can add address and all...


    public Theatre(int id, String name) {
        this.id = id;
        this.name = name;
        this.listOfScreens = new ArrayList<>();
    }

    public void addScreen(Screen screen){
        listOfScreens.add(screen);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getListOfScreens() {
        return listOfScreens;
    }
}
