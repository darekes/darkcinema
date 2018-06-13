package mas.Reservation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Darek on 2018-06-13.
 */
public class ReservationService {

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository reservationRepository;
}
