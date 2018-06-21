package mas.Reservation;

import mas.Person.ClientRepository;
import mas.Person.ClientService;
import mas.Seance.Seance;
import mas.Seance.SeanceRepository;
import mas.Seance.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        reservation.setPromotion(null);
        reservation.setIsPaid(false);
        reservation.setReservationDate(LocalDateTime.now());
        reservationRepository.save(reservation);

        return reservation;
    }
}
