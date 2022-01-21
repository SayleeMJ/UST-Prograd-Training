package engineer.saylee.BOOKMYTICKET.service;


import engineer.saylee.BOOKMYTICKET.entity.Seats;
import engineer.saylee.BOOKMYTICKET.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public Seats getBySeats(String seats){
        return  seatRepository.getBySeats(seats);
    }
}
