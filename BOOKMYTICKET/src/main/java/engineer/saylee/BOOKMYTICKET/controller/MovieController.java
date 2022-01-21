package engineer.saylee.BOOKMYTICKET.controller;
import engineer.saylee.BOOKMYTICKET.entity.Movie;
import engineer.saylee.BOOKMYTICKET.entity.MovieShow;
import engineer.saylee.BOOKMYTICKET.service.MovieService;
import engineer.saylee.BOOKMYTICKET.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieShowService movieShowService;
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/{movieId}")
    public String movieShow(@PathVariable Long movieId, Model model){
        model.addAttribute("shows", movieShowService.showDetails(movieId));
        Movie movie = movieService.getByMovieId(movieId);
        model.addAttribute("movie", movie);
        return "movieDetails";
    }
    @GetMapping("/movie/{movieId}/{showId}")
    public String movieShow(@PathVariable Long movieId,@PathVariable Long showId, Model model){
        model.addAttribute("shows", movieShowService.getById(showId));
        MovieShow movieshow = movieShowService.getById(showId);
        String bookedSeats = movieshow.getBookedSeats();
        ArrayList<String> listOfString = new ArrayList<String>();
        if(bookedSeats != null) {
            String[] elements = bookedSeats.split(",");
            List<String> fixedLenghtList = Arrays.asList(elements);
            listOfString = new ArrayList<String>(fixedLenghtList);
            model.addAttribute("bookedSeats", listOfString);
        }
        Movie movie = movieService.getByMovieId(movieId);
        model.addAttribute("movie", movie);
        return "bookSeats";
    }
}