package engineer.saylee.BOOKMYTICKET.repository;


import engineer.saylee.BOOKMYTICKET.entity.SeatsBooked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatsBookedRepository extends JpaRepository<SeatsBooked, Long> {

    public boolean existsBySeats(String seat);

    public List<SeatsBooked> findByMovieShowId(Long id);
}
