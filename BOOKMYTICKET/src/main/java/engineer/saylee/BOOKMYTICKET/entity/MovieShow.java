package engineer.saylee.BOOKMYTICKET.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class MovieShow {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private Time time;
    private String theaterName;
    private Integer seatAvailability;
    private String bookedSeats;
    private  Integer ticketPrice;

    @JsonIgnore
    @ManyToOne
    private Movie movie;

    @OneToMany(mappedBy = "movieShow")
    private List<SeatsBooked> seatsBooked;

    @OneToMany(mappedBy = "movieShow")
    private List<Seats> seats;

    public MovieShow(){}

    public MovieShow(Date date, Time time, String theaterName, Integer seatAvailability, String bookedSeats, Integer ticketPrice) {
        this.date = date;
        this.time = time;
        this.theaterName = theaterName;
        this.seatAvailability = seatAvailability;
        this.bookedSeats = bookedSeats;
        this.ticketPrice = ticketPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<SeatsBooked> getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(List<SeatsBooked> seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public Integer getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(Integer seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public String getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(String bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
