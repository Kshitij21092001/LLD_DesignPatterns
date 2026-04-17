package BookMyShow.Controller;

import BookMyShow.Entities.Movie;
import BookMyShow.Entities.Show;
import BookMyShow.Entities.Theatre;
import BookMyShow.Enums.City;
import BookMyShow.Services.TheatreService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(){
        this.theatreService = new TheatreService();
    }

    public void addTheatre(Theatre theatre){
        theatreService.addTheatre(theatre);
    }

    public Set<Movie> getMovies(City city, LocalDate date){
        return theatreService.getMovies(city, date);
    }

    public List<Theatre> getTheatres(City city, Movie movie, LocalDate date){
        return theatreService.getTheatre(city, movie, date);
    }

    public List<Show> getShows(Theatre theatre, Movie movie, LocalDate date){
        return theatreService.getShows(theatre,movie,date);
    }
}
