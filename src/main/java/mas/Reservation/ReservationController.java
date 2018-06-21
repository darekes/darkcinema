package mas.Reservation;

import mas.Person.Client;
import mas.Person.ClientService;
import mas.Registration.ClientRegistrationForm;
import mas.Seance.Seance;
import mas.Seance.SeanceService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Darek on 2018-06-21.
 */

@Controller
public class ReservationController {

    @Autowired
    SeanceService seanceService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ClientService clientService;

    Map<String, Long> params = new HashedMap();

    @RequestMapping(value = { "/reservations" }, method = RequestMethod.GET)
    public String getReservations(Model model){
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations",reservations);
        return "reservations";
    }

    @RequestMapping(value = "/reservation-step1", method = RequestMethod.GET)
    public String getSeances(Model model){
        List<Seance> seances = seanceService.getAllSeances();
        model.addAttribute("seances", seances);
        return "reservation-step1";
    }

    @RequestMapping(value = "/reservation-step2", method = RequestMethod.GET)
    public String saveReservationStep2(@RequestParam("seanceId") Long id, Model model){
        params.put("seanceId", id);
        List<Client> clients = clientService.getClientList();
        model.addAttribute("clients", clients);
        return "reservation-step2";
    }

    @RequestMapping(value = "/reservation-step3", method = RequestMethod.GET)
    public String saveReservationStep3(@RequestParam("clientId") Long id, Model model){
        params.put("clientId", id);
        Reservation reservation = reservationService.insertReservation(params);
        model.addAttribute("reservation", reservation);
        return "reservation-successfull";
    }

    @RequestMapping("/reservation-successfull")
    public String getReservationSuccessfull(Model model){
        return "reservation-successfull";
    }
}
