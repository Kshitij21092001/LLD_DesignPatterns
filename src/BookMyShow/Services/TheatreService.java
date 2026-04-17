package BookMyShow.Services;

import BookMyShow.Entities.Movie;
import BookMyShow.Entities.Screen;
import BookMyShow.Entities.Show;
import BookMyShow.Entities.Theatre;
import BookMyShow.Enums.City;

import java.time.LocalDate;
import java.util.*;

public class TheatreService {
    private final Map<City, List<Theatre>> cityTheatre = new HashMap<>();

    public void addTheatre(Theatre theatre){
        cityTheatre
                .computeIfAbsent(theatre.getCity(),c->new ArrayList<>())
                .add(theatre);
    }

    public Set<Movie> getMovies(City city, LocalDate date){
        Set<Movie> movies = new HashSet<>();
        List<Theatre> theatreList = cityTheatre.getOrDefault(city,List.of());

        for(Theatre theatre : theatreList){
            for(Screen screen : theatre.getScreens()){
                for(Show show : screen.getShow(date)){
                    movies.add(show.getMovie());
                }
            }
        }

        return movies;
    }

    public List<Theatre> getTheatre(City city, Movie movie, LocalDate date){
        List<Theatre> theatreList = cityTheatre.getOrDefault(city,List.of());

        return theatreList.stream()
                .filter(t->t.getScreens().stream()
                        .anyMatch(s->s.getShow(date).stream()
                                .anyMatch(show->show.getMovie().equals(movie))))
                .toList();
    }

    public List<Show> getShows(Theatre theatre, Movie movie, LocalDate date){
        List<Show> showList = new ArrayList<>();

        for(Screen screen : theatre.getScreens()){
            for(Show show : screen.getShow(date)){
                if(show.getMovie().equals(movie)){
                    showList.add(show);
                }
            }
        }
        return showList;
    }
}
