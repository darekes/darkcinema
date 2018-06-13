package mas.Reservation;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Darek on 2018-06-13.
 */
public interface ReservationRepository {
    List<Reservation> findByClientId(String clientId);
    List<Reservation> findBySeanceId(Seance seanceId);
    List<Reservation> findByPromotionId(String promotionId);
    List<Reservation> findByReservationDate(LocalDate localDate);
}
