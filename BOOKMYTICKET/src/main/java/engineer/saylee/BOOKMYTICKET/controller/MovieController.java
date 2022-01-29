package engineer.saylee.BOOKMYTICKET.controller;
import engineer.saylee.BOOKMYTICKET.entity.Movie;
import engineer.saylee.BOOKMYTICKET.entity.MovieShow;
import engineer.saylee.BOOKMYTICKET.entity.SeatsBooked;
import engineer.saylee.BOOKMYTICKET.entity.User;
import engineer.saylee.BOOKMYTICKET.service.MovieService;
import engineer.saylee.BOOKMYTICKET.service.MovieShowService;
import engineer.saylee.BOOKMYTICKET.service.SeatsBookedService;
import engineer.saylee.BOOKMYTICKET.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieShowService movieShowService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private SeatsBookedService seatsBookedService;
    @Autowired
    private UserService userService;

    @GetMapping("/movie/{movieId}")
    public String movieShow(@PathVariable Long movieId, Model model){
        model.addAttribute("shows", movieShowService.showDetails(movieId));
        Movie movie = movieService.getByMovieId(movieId);
        model.addAttribute("movie", movie);
        return "movieDetails";
    }
    @GetMapping("/movieShows/{showId}")
    public String movieShow(@PathVariable Long showId, Model model, HttpSession session){
        String username = (String) session.getAttribute("userName");
        model.addAttribute("shows", movieShowService.getById(showId));
        model.addAttribute("userName", username);
        MovieShow movieshow = movieShowService.getById(showId);
        String bookedSeats = movieshow.getBookedSeats();
        ArrayList<String> listOfString = new ArrayList<String>();
        if(bookedSeats != null) {
            String[] elements = bookedSeats.split(",");
            List<String> fixedLengthList = Arrays.asList(elements);
            listOfString = new ArrayList<String>(fixedLengthList);
            model.addAttribute("bookedSeats", listOfString);
        }
        return "bookSeats";
    }

    @PostMapping("/confirmBooking")
    public String confirmBooking(HttpServletRequest request, Model model){
        User username = userService.findByUsername(request.getParameter("username"));
        MovieShow movieShow = movieShowService.getById(Long.valueOf(request.getParameter("show")));
        String seats = request.getParameter("seats");
        String totalSeats = request.getParameter("totalSeats");
        String ticketPrice = request.getParameter("ticketPrice");

        String bookedSeats = movieShow.getBookedSeats();
        Integer availableSeats = movieShow.getSeatAvailability();
        if(bookedSeats != null) {
            bookedSeats += ",";
            bookedSeats += seats;
        }
        else {
            bookedSeats = seats;
        }
        availableSeats -= Integer.valueOf(totalSeats);
        movieShow.setBookedSeats(bookedSeats);
        movieShow.setSeatAvailability(availableSeats);
        movieShowService.save(movieShow);
        SeatsBooked seatsBooked = new SeatsBooked(seats, totalSeats, ticketPrice, username, movieShow);
        seatsBookedService.saveSeat(seatsBooked);
        return "booked";
    }

    @RequestMapping("/myShows")
    public String myShows(Model model, HttpSession session){
        if(session.getAttribute("userName") != null) {
            User username = userService.findByUsername((String) session.getAttribute("userName"));
            model.addAttribute("details", seatsBookedService.getByUsername(username));
            model.addAttribute("username", username.getUsername());
            return "myShows";
        }else{
            return "redirect:/login";
        }
    }
}