package mas.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darek on 2018-06-13.
 */

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        List<Reservation> list = new ArrayList<>();
        Iterable<Reservation> iterable = reservationRepository.findAll();
        iterable.forEach(list::add);
        return list;
    }
}
