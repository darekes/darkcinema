package mas.Reservation;

import mas.Discounts.LoyaltyProgramService;
import mas.Person.Client;
import mas.Person.ClientRepository;
import mas.Person.ClientService;
import mas.Seance.Seance;
import mas.Seance.SeanceRepository;
import mas.Seance.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Darek on 2018-06-13.
 */

@Service
public class ReservationService {

    @Autowired
    SeanceRepository seanceRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    SeanceService seanceService;

    @Autowired
    LoyaltyProgramService loyaltyProgramService;

    public List<Reservation> getAllReservations(){
        List<Reservation> list = new ArrayList<>();
        Iterable<Reservation> iterable = reservationRepository.findAll();
        iterable.forEach(list::add);
        return list;
    }

    public Reservation insertReservation(Map<String, Long> params){
        Reservation reservation = new Reservation();
        reservation.setSeance(seanceService.getSeanceById(params.get("seanceId")));
        reservation.setClient(clientService.getClientById(params.get("clientId")));
        reservation.setLoyaltyProgram(null);
        reservation.setIsPaid(false);
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setState(State.CONFIRMED);
        reservationRepository.save(reservation);

        return reservation;
    }

    public void applyDiscount(Reservation reservation){
        BigDecimal discount = loyaltyProgramService.getAllLoyaltyPrograms().get(0).getDiscount();
        reservation.setCost(reservation.getCost().subtract(discount));
        reservationRepository.save(reservation);
    }
}
