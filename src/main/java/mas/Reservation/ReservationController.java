package mas.Reservation;

import mas.Discounts.LoyaltyProgram;
import mas.Discounts.LoyaltyProgramService;
import mas.Person.Client;
import mas.Person.ClientService;
import mas.Registration.ClientRegistrationForm;
import mas.Seance.Seance;
import mas.Seance.SeanceService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    LoyaltyProgramService loyaltyProgramService;

    Map<String, Long> params = new HashedMap();

    @RequestMapping(value = { "/reservations" }, method = RequestMethod.GET)
    public String getReservations(Model model){
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations",reservations);
        return "reservations";
    }

    @RequestMapping(value = "/reservation-step1", method = RequestMethod.GET)
    public String getSeancesView(Model model){
        List<Seance> seances = seanceService.getAllSeances();
        model.addAttribute("seances", seances);
        return "reservation-step1";
    }

    @RequestMapping(value = "/reservation-step2", method = RequestMethod.GET)
    public String getClientsView(@RequestParam("seanceId") Long id, Model model){
        params.put("seanceId", id);
        Seance seance = seanceService.getSeanceById(id);
        seanceService.incrementAmountOfVisitors(seance);
        List<Client> clients = clientService.getClientList();
        model.addAttribute("clients", clients);
        return "reservation-step2";
    }

    @RequestMapping(value = "/reservation-step3", method = RequestMethod.GET, params = {"confirm"})
    public String confirmRegistration(Model model, @RequestParam("clientId") Long id, @RequestParam("confirm") String confirm){
        params.put("clientId", id);
        Reservation reservation = reservationService.insertReservation(params);
        Client client = clientService.getClientById(id);
        clientService.incrementVisits(client);
        model.addAttribute("reservation", reservation);
        return "reservation-successful";
    }

    @RequestMapping(value = "/reservation-step3", method = RequestMethod.GET, params = {"checkDiscount"})
    public String checkDiscounts(Model model, @RequestParam("clientId") Long id, @RequestParam("checkDiscount") String checkDiscount){
        params.put("clientId", id);
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        LoyaltyProgram program = loyaltyProgramService.getAllLoyaltyPrograms().get(0);
        model.addAttribute("program", program);
        model.addAttribute("isClientAbleToGetDiscount", clientService.isClientAbleToGetDiscount(client, program));
        return "discounts";
    }

    @GetMapping("/confirm-registration")
    public String confirmRegistrationWithDiscount(Model model, @RequestParam(value = "discountApplied", required = false) String discountApplied){
        Reservation reservation = reservationService.insertReservation(params);
        Client client = clientService.getClientById(params.get("clientId"));
        clientService.incrementVisits(client);
        if(discountApplied != null){
            reservationService.applyDiscount(reservation);
        }
        model.addAttribute("reservation", reservation);
        return "reservation-successful";
    }
}