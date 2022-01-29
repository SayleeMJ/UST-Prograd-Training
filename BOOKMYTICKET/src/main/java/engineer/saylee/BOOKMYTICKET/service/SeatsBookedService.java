package engineer.saylee.BOOKMYTICKET.service;

import engineer.saylee.BOOKMYTICKET.entity.MovieShow;
import engineer.saylee.BOOKMYTICKET.entity.SeatsBooked;
import engineer.saylee.BOOKMYTICKET.entity.User;
import engineer.saylee.BOOKMYTICKET.repository.SeatsBookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsBookedService {

    @Autowired
    private SeatsBookedRepository seatsBookedRepository;

    public List<SeatsBooked> getByUsername(User user){
        return seatsBookedRepository.getByUsername(user);
    }

    public SeatsBooked saveSeat(SeatsBooked seatsBooked) {
        return seatsBookedRepository.save(seatsBooked);
    }

    public List<SeatsBooked> findByShowId(Long id){
        return seatsBookedRepository.findByMovieShowId(id);
    }
}
