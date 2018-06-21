package mas.Reservation;

import mas.Seance.Seance;
import mas.Seance.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Darek on 2018-06-21.
 */

@Controller
public class ReservationController {

    @Autowired
    SeanceService seanceService;

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = { "/reservations" }, method = RequestMethod.GET)
    public String getReservations(Model model){
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations",reservations);
        return "reservations";
    }

    @RequestMapping(value = { "/reservation-step1" }, method = RequestMethod.GET)
    public String getSeance(Model model){
        List<Seance> seances = seanceService.getAllSeances();
        model.addAttribute("seances",seances);
        return "reservation-step1";
    }
}
