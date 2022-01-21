//package engineer.saylee.BOOKMYTICKET.controller;
//
//import engineer.saylee.BOOKMYTICKET.entity.Seats;
//import engineer.saylee.BOOKMYTICKET.entity.SeatsBooked;
//import engineer.saylee.BOOKMYTICKET.service.MovieShowService;
//import engineer.saylee.BOOKMYTICKET.service.SeatService;
//import engineer.saylee.BOOKMYTICKET.service.SeatsBookedService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class SeatsBookedController {
//    @Autowired
//    private SeatService seatService;
//
//    @Autowired
//    private SeatsBookedService seatsBookedService;
//
//    @Autowired
//    private MovieShowService movieShowService;
//
//    @GetMapping("/seats/{id}")
//    public String seats(@PathVariable Long id, Model model){
//        model.addAttribute("shows",id);
//        return "seats";
//    }
//
//    @GetMapping("/booked/{shows}")
//    public String booked(@PathVariable Long shows, Model model){
//        model.addAttribute("shows",shows);
//        return "booked";
//    }
//
//    @PostMapping("/booked/{shows}")
//    public String seatBooked(@PathVariable Long shows,HttpServletRequest servletRequest, Model model){
//        String seatsBook = servletRequest.getParameter("seatsBooked");
//        String[] seatBooked = seatsBook.split(",");
//        for(String seat : seatBooked){
//            if (!seatsBookedService.existsBySeats(seat) && movieShowService.existsById(shows)){
//                Seats seats = seatService.getBySeats(seat);
//                SeatsBooked seatsBooked = new SeatsBooked(seats.getSeats(), seats.getPrice());
//                seatsBookedService.saveSeat(seatsBooked);
//            }else{
//                model.addAttribute("message",seat + "Seat is already booked.. choose another...");
//    //               return "seats";
//                return "redirect:/seats/" + shows;
//            }
//        }
//        return "booked";
//    }
//
//}
