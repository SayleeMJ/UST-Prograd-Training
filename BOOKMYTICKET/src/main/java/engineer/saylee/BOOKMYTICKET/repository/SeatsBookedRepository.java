package engineer.saylee.BOOKMYTICKET.repository;


import engineer.saylee.BOOKMYTICKET.entity.SeatsBooked;
import engineer.saylee.BOOKMYTICKET.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatsBookedRepository extends JpaRepository<SeatsBooked, Long> {

    public List<SeatsBooked> findByMovieShowId(Long id);

    @Query("SELECT u FROM SeatsBooked u WHERE u.user=:user")
    List<SeatsBooked> getByUsername(User user);
}
