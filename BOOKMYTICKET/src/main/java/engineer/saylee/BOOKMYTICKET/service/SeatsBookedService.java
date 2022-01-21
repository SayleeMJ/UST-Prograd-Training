package engineer.saylee.BOOKMYTICKET.service;

import engineer.saylee.BOOKMYTICKET.entity.SeatsBooked;
import engineer.saylee.BOOKMYTICKET.repository.SeatsBookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsBookedService {

    @Autowired
    private SeatsBookedRepository seatsBookedRepository;

    public boolean existsBySeats(String seats) {
        return seatsBookedRepository.existsBySeats(seats);
    }

    public SeatsBooked saveSeat(SeatsBooked seatsBooked) {
        return seatsBookedRepository.save(seatsBooked);
    }

    public List<SeatsBooked> findByShowId(Long id){
        return seatsBookedRepository.findByMovieShowId(id);
    }
}
