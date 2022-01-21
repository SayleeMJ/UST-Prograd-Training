package engineer.saylee.BOOKMYTICKET.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long movieId;
    private String movieName;
    private String genre;
    private String ratings;
    private String duration;
    private Date movieReleaseDate;
    private String moviePoster;
    private String movieDesc;
    private String actor;
    private String actress;

    @OneToMany(mappedBy = "movie")
    private List<MovieShow> movieShow;

    public Movie(){}

    public Movie(String movieName, String genre, String ratings, String duration, Date movieReleaseDate, String moviePoster, String movieDesc) {
        this.movieName = movieName;
        this.genre = genre;
        this.ratings = ratings;
        this.duration = duration;
        this.movieReleaseDate = movieReleaseDate;
        this.moviePoster = moviePoster;
        this.movieDesc = movieDesc;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<MovieShow> getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(List<MovieShow> movieShow) {
        this.movieShow = movieShow;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }
}
