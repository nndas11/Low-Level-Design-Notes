package BehaviouralDesignPatterns.LLDProblems.BookMyShow.Service;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.City;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Movie;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Show;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Theatre;

import java.util.List;
import java.util.Map;
import java.util.Set;


//  we can do map -> if need constant lookup time -> optimization -> talk with interviewer and decide the logic.
public class TheatreService {
    private Map<City, Set<Movie>> cityVsMovies;
    private Map<Integer, Theatre> theatres;
//    private Map<Movie, List<Show>> movieVsShow; -> could be an overkill for LLD interview.


}
