package engineer.saylee.BOOKMYTICKET.repository;


import engineer.saylee.BOOKMYTICKET.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
    public List<MovieShow> findByMovieMovieId(Long MovieId);


// select * from MovieShow where movie_movie_id = movieId group by theater_name
    /*

    @Query(
            " SELECT *  FROM MOVIESHOW WHERE MOVIE_MOVIE_ID = MovieId  GROUPBY theaterName"
    )*/



}
