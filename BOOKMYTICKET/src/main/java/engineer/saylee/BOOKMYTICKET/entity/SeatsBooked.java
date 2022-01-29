package engineer.saylee.BOOKMYTICKET.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SeatsBooked {
    @Id
    @GeneratedValue
    private Long id;
    private String seatNumbers;
    private String seatsCount;
    private String ticketPrice;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private MovieShow movieShow;

    public SeatsBooked(){

    }

    public SeatsBooked(String seatNumbers, String seatsCount, String ticketPrice, User user, MovieShow movieShow){
        this.seatNumbers = seatNumbers;
        this.seatsCount = seatsCount;
        this.ticketPrice = ticketPrice;
        this.user = user;
        this.movieShow = movieShow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(String seatsCount) {
        this.seatsCount = seatsCount;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
    }
}
