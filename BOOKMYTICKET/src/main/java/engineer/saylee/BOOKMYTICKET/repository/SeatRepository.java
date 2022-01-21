package engineer.saylee.BOOKMYTICKET.repository;

import engineer.saylee.BOOKMYTICKET.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SeatRepository extends JpaRepository<Seats, Long> {
    public Seats getBySeats(String seats);
}
